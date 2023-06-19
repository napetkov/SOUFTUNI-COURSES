import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class GetMinionNames {

    private static final String GET_MINIONS_NAMES_AND_AGES_BY_VILLAINS_ID =
            "select m.name as minion_name, age as minion_age, v.name as villains_name " +
                    "from minions as m " +
                    "join minions_villains mv on m.id = mv.minion_id " +
                    "join villains v on v.id = mv.villain_id " +
                    "where mv.villain_id = ?; ";
    private static final String PRINT_FORMAT_VILLAINS_NAME = "Villain: %s %n";
    private static final String PRINT_MINIONS_NAMES_AND_AGES = "%d. %s %d %n";
    private static final String COLUMN_LABEL_VILLAINS_NAME = "villains_name";
    private static final String COLUMN_LABEL_MINION_NAME= "minion_name";
    private static final String COLUMN_LABEL_MINION_AGE = "minion_age";

    public static void main(String[] args) throws SQLException {
        System.out.print("Enter a ID number of Villain: ");
        int villainId = new Scanner(System.in).nextInt();

        final Connection connection = Utils.getSQLConnection();

        final PreparedStatement statement = connection.prepareStatement(GET_MINIONS_NAMES_AND_AGES_BY_VILLAINS_ID);

        statement.setInt(1, villainId);

        final ResultSet result = statement.executeQuery();

        print(result);

    }

    private static void print(ResultSet result) throws SQLException {
        int counterOfMinions = 1;
        boolean isPrintedVillainsName = false;

        while (result.next()) {

            final String villainsName = result.getString(COLUMN_LABEL_VILLAINS_NAME);

            if(!isPrintedVillainsName){

                System.out.printf(PRINT_FORMAT_VILLAINS_NAME, villainsName);
                isPrintedVillainsName = true;
            }

            final String minionName = result.getString(COLUMN_LABEL_MINION_NAME);
            final int minionAge = result.getInt(COLUMN_LABEL_MINION_AGE);

            System.out.printf(PRINT_MINIONS_NAMES_AND_AGES, counterOfMinions, minionName, minionAge);

            counterOfMinions++;
        }
    }
}
