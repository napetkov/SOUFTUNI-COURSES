import entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {


    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory sessionFactory =
                cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<Student> allStudents = session.
                createQuery("FROM Student ", Student.class)
                .list();


        allStudents.forEach(System.out::println);

        session.getTransaction().commit();
        session.close();


    }
}
