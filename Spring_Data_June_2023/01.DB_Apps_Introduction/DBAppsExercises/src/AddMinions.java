import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class AddMinions {

    private static final String PRINT_VILLAIN_ADD_FORMAT = "Villain %s was added to the database.\n";
    private static final String GET_VILLAIN_BY_NAME = "select id from villains where name = ?; ";
    private static final String INSERT_INTO_VILLAIN = "insert into villains(name, evilness_factor) values (?, 'evil') ";


    private static final String PRINT_MINION_TO_VILLAIN_ADD_FORMAT = "Successfully added %s to be minion of %s.\n";
    private static final String GET_LAST_MINION_BY_NAME = "select id from minions where name = ? order by id desc limit 1; ";
    private static final String INSERT_MINION = "insert into minions(name, age, town_id) values (?, ?, ?); ";
    private static final String INSERT_MINION_VILLAINS = "insert into minions_villains(minion_id, villain_id) values (?, ?); ";


    private static final String PRINT_TOWN_ADD_FORMAT = "Town %s was added to the database.\n";
    private static final String GET_TOWN_BY_NAME = "select id from towns where name = ? ";
    private static final String INSERT_INTO_TOWNS = "insert into towns(name) values (?) ";


    public static void main(String[] args) throws SQLException {

        final Connection sqlConnection = Utils.getSQLConnection();

        final Scanner scanner = new Scanner(System.in);

        final String[] minionsInfo = scanner.nextLine().split(" ");
        final String minionName = minionsInfo[1];
        final int minionAge = Integer.parseInt(minionsInfo[2]);
        final String minionTown = minionsInfo[3];

        final String villainsName = scanner.nextLine().split(" ")[1];


        int townId = getEntryId(sqlConnection,
                List.of(minionTown),
                GET_TOWN_BY_NAME,
                INSERT_INTO_TOWNS,
                PRINT_TOWN_ADD_FORMAT);
        int villainId = getEntryId(sqlConnection,
                List.of(villainsName),
                GET_VILLAIN_BY_NAME,
                INSERT_INTO_VILLAIN,
                PRINT_VILLAIN_ADD_FORMAT);

        final PreparedStatement insertMinionsStatement = sqlConnection.prepareStatement(INSERT_MINION);
        insertMinionsStatement.setString(1,minionName);
        insertMinionsStatement.setInt(2,minionAge);
        insertMinionsStatement.setInt(3,townId);

        insertMinionsStatement.executeUpdate();

        final PreparedStatement lastMinion = sqlConnection.prepareStatement(GET_LAST_MINION_BY_NAME);
        lastMinion.setString(1, minionName);
        ResultSet result = lastMinion.executeQuery();
        result.next();

        final int minionId = result.getInt("id");

        PreparedStatement insertMinionVillain = sqlConnection.prepareStatement(INSERT_MINION_VILLAINS);
        insertMinionVillain.setInt(1, minionId);
        insertMinionVillain.setInt(2, villainId);

        insertMinionVillain.executeUpdate();

        System.out.printf(PRINT_MINION_TO_VILLAIN_ADD_FORMAT,minionName,villainsName);

    }

    private static int getEntryId(
            Connection sqlConnection,
            List<String> arguments,
            String getQuery,
            String insertQuery,
            String printOutputMassage
            ) throws SQLException {
        final String name = arguments.get(0);

        final PreparedStatement statement = sqlConnection.prepareStatement(getQuery);
        statement.setString(1, name);

        final ResultSet result = statement.executeQuery();

        if (!result.next()) {
            final PreparedStatement insertStatement = sqlConnection.prepareStatement(insertQuery);
            for (int i = 1; i <= arguments.size(); i++) {
                insertStatement.setString(i, arguments.get(i-1));
            }

            insertStatement.executeUpdate();

            final ResultSet resultAfterUpdate = statement.executeQuery();

            resultAfterUpdate.next();

            System.out.printf(printOutputMassage, name);

            return resultAfterUpdate.getInt("id");
        }

        return result.getInt("id");
    }
}
