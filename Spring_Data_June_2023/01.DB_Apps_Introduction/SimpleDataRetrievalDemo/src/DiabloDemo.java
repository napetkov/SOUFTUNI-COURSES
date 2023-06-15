import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DiabloDemo {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/diablo","root", "gebruX3r2107");


    }

}
