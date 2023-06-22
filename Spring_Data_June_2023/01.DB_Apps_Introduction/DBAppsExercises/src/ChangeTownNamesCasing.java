import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChangeTownNamesCasing {
    private static final String UPDATE_TOWNS_ALL_NAMES_TO_UPPER_BY_COUNTRY = "update towns set name  = upper(name) where country = ?; ";
    private static final String GET_TOWNS_BY_COUNTRY = "select name from towns where country = ?; ";
    private static final String GET_COUNT_OF_UPDATED_TOWNS = "select count(name) from towns where country = ?; ";

    private static final String PRINT_FORMAT_COUNT_OF_TOWNS = "%d town names were affected.\n";
    private static final String PRINT_FORMAT_ALL_NAMES_OF_TOWNS = "[%s]";
    private static final String PRINT_FORMAT_NO_TOWNS_WERE_AFFECTED = "No town names were affected. \n";
    public static void main(String[] args) throws SQLException {

        Connection connection = Utils.getSQLConnection();
        System.out.println("Please insert country: ");
        final String country = new Scanner(System.in).nextLine();

        final PreparedStatement updateTownsToUpperCaseStatement = connection.prepareStatement(UPDATE_TOWNS_ALL_NAMES_TO_UPPER_BY_COUNTRY);
        updateTownsToUpperCaseStatement.setString(1, country);

        int updateResult = updateTownsToUpperCaseStatement.executeUpdate();

        if(updateResult != 0){
            final PreparedStatement getChangedTownsStatement = connection.prepareStatement(GET_TOWNS_BY_COUNTRY);
            getChangedTownsStatement.setString(1,country);

            final PreparedStatement getCountOfChangedTownsStatement = connection.prepareStatement(GET_COUNT_OF_UPDATED_TOWNS);
            getCountOfChangedTownsStatement.setString(1,country);

            final ResultSet getTownsResult = getChangedTownsStatement.executeQuery();
            ResultSet getCountResult = getCountOfChangedTownsStatement.executeQuery();

            getCountResult.next();
            int countOfChangedNameTowns = getCountResult.getInt(1);

            List <String> allTownsNamesUpperCase = new ArrayList<>();

            while (getTownsResult.next()){
                allTownsNamesUpperCase.add(getTownsResult.getString("name"));
            }

            System.out.printf(PRINT_FORMAT_COUNT_OF_TOWNS, countOfChangedNameTowns);
            System.out.printf(PRINT_FORMAT_ALL_NAMES_OF_TOWNS,String.join(" ",allTownsNamesUpperCase));


        }else {
            System.out.println(PRINT_FORMAT_NO_TOWNS_WERE_AFFECTED);
        }

        connection.close();
    }
}
