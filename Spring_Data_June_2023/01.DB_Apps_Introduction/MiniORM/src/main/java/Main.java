import entities.Department;
import entities.User;
import orm.EntityManager;
import orm.config.Connector;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws SQLException {

        Connector.createConnection("root","gebruX3r2107","soft_uni");

        Connection connection = Connector.getConnection();

        EntityManager<User> userEntityManager = new EntityManager<User>(connection);
        userEntityManager.persist(new User("user","pass", 2, LocalDate.now()));

//        EntityManager<Department> departmentEntityManager = new EntityManager<Department>(connection);
//        departmentEntityManager.persist(new Department());

    }
}