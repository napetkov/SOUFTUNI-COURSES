import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetVillainsNames {
    private static final String GET_VILLAINS_NAMES =
            "select v.name, count(distinct mv.minion_id) as number_of_minions from villains as v " +
                    "join minions_villains mv on v.id = mv.villain_id " +
                    "group by v.id " +
                    "having number_of_minions > ? " +
                    "order by number_of_minions desc;";
    private static final String PRINT_FORMAT = "%s %d %n";
    private static final String COLUMN_LABEL_NAME = "name";
    private static final String COLUMN_LABEL_NUMBER_OF_MINIONS = "number_of_minions";

    public static void main(String[] args) throws SQLException {

        final Connection connection = Utils.getSQLConnection();

        final PreparedStatement statement = connection.prepareStatement(GET_VILLAINS_NAMES);

        statement.setInt(1, 15);

        final ResultSet result = statement.executeQuery();

        while (result.next()) {

            print(result);

        }

        connection.close();
    }

    private static void print(ResultSet result) throws SQLException {

        final String name = result.getString(COLUMN_LABEL_NAME);
        final int numberOfMinions = result.getInt(COLUMN_LABEL_NUMBER_OF_MINIONS);

        System.out.printf(PRINT_FORMAT, name, numberOfMinions);
    }
}