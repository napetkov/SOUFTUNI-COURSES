import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class DiabloDemo {
    private static final String SELECT_USER_GAME_COUNT_BY_USERNAME = "set sql_mode = 'STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION'; " +
            "select users.first_name,users.last_name,count(ug.game_id)" +
            "from users" +
            "         join users_games ug on users.id = ug.user_id " +
            "where users.user_name = ?";

    public static void main(String[] args) throws SQLException {
        Connection connection = getMySQLConnectiuon();


        String username = readUsername();

        PreparedStatement statement = connection.prepareStatement(SELECT_USER_GAME_COUNT_BY_USERNAME);
        statement.setString(1, username);

        ResultSet result = statement.executeQuery();
        result.getString("first_name");
    }

    private static String readUsername() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        return username;
    }

    private static Connection getMySQLConnectiuon() throws SQLException {
        Properties userPass = new Properties();
        userPass.setProperty("user", "root");
        userPass.setProperty("password", "gebruX3r2107");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/diablo", "root", "gebruX3r2107");

        return connection;
    }

}
