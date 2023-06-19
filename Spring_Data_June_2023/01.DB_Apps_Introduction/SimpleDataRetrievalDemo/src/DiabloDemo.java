import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class DiabloDemo {
    private static final String SELECT_USER_GAME_COUNT_BY_USERNAME =
            "select first_name,last_name,count(ug.game_id) " +
            "from users " +
            "join users_games ug on users.id = ug.user_id " +
            "where user_name = ? " +
            "group by first_name, last_name";

    private static final String SELECT_USER_COUNT_BY_USERNAME = "select count(*) from users where user_name = ?";

    public static void main(String[] args) throws SQLException {
        Connection connection = getMySQLConnection();

        String username = readUsername();

        PreparedStatement statement = connection.prepareStatement(SELECT_USER_GAME_COUNT_BY_USERNAME);
        statement.setString(1, username);

        boolean usersExists = getUsersExists(connection, username);

        ResultSet result = statement.executeQuery();
        if(usersExists){
            result.next();
            System.out.printf("User: %s%n", username);
            System.out.printf("%s %s has played %d games",
                    result.getString("first_name"),result.getString("last_name"),result.getInt(3));
        }else{
            System.out.println("No such user exists");
        }
    }

    private static boolean getUsersExists(Connection connection, String username) throws SQLException {
        PreparedStatement existStatement = connection.prepareStatement(SELECT_USER_COUNT_BY_USERNAME);
        existStatement.setString(1, username);

        ResultSet existResult = existStatement.executeQuery();

        existResult.next();
        int rowCount = existResult.getInt(1);

        return rowCount > 0;
    }

    private static String readUsername() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username: ");

        return scanner.nextLine();
    }

    private static Connection getMySQLConnection() throws SQLException {
        Properties userPass = new Properties();
        userPass.setProperty("user", "root");
        userPass.setProperty("password", "gebruX3r2107");

        return DriverManager.getConnection("jdbc:mysql://localhost:3306/diablo", "root", "gebruX3r2107");
    }

}
