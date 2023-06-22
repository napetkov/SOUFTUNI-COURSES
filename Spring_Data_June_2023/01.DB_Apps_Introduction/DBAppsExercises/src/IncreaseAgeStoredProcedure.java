import jdk.jshell.execution.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class IncreaseAgeStoredProcedure {
    public static final String CALL_PROCEDURE = "call usp_get_older(?); ";
    public static final String SELECT_NAME_AND_AGE_OF_MINION_BY_ID = "select name,age from minions where id = ?";
    public static final String OUTPUT_PRINT_FORMAT =
            "Minion name: %s\n" +
            "Minion age: %d";

    public static void main(String[] args) throws SQLException {
        System.out.println("Insert Id of minions who wants to grow up with one year:");
        final int minionId = new Scanner(System.in).nextInt();

        Connection connection = Utils.getSQLConnection();

        final PreparedStatement callProcedureStatement = connection.prepareStatement(CALL_PROCEDURE);
        callProcedureStatement.setInt(1, minionId);

        callProcedureStatement.executeUpdate();

        final PreparedStatement minionsNameAndAgesStatement = connection.prepareStatement(SELECT_NAME_AND_AGE_OF_MINION_BY_ID);
        minionsNameAndAgesStatement.setInt(1,minionId);
        final ResultSet resultSet = minionsNameAndAgesStatement.executeQuery();

        resultSet.next();

        System.out.printf(OUTPUT_PRINT_FORMAT, resultSet.getString("name"),resultSet.getInt("age"));

        connection.close();

    }
}
