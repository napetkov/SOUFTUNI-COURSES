import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

public class IncreaseMinionsAge {
    private static final String UPDATE_AGE_AND_NAME_OF_MINION_BY_ID = "update minions set age = age + 1, name = lower(name) where id = ?; ";
    private static final String SELECT_NAMES_AND_AGE_OF_MINIONS = "select name, age from minions; ";
    private static final String OUTPUT_PRINT_FORMAT = "%s %d\n";


    public static void main(String[] args) throws SQLException {
        Connection connection = Utils.getSQLConnection();

        System.out.println("Insert Id for minions separate with space: ");

        final int[] minionsId = Arrays.stream(new Scanner(System.in).nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int id : minionsId) {

            PreparedStatement updateNameAgeStatement = connection.prepareStatement(UPDATE_AGE_AND_NAME_OF_MINION_BY_ID);
            updateNameAgeStatement.setInt(1, id);

            updateNameAgeStatement.executeUpdate();

        }

        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_NAMES_AND_AGE_OF_MINIONS);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.printf(OUTPUT_PRINT_FORMAT,resultSet.getString("name"),resultSet.getInt("age"));
        }

        connection.close();

    }
}
