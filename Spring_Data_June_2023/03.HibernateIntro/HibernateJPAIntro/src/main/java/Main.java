import entities.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("school");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Student student = new Student("TeoNew1", 10, "School 1");
        em.persist(student);
//
//        student.setName("TeoUpdated");
//        em.persist(student);

//        Student student1 = em.find(Student.class, 3);

//        em.remove(student1);

//        System.out.println(student1.getId());

        List<Student> fromStudent = em.createQuery("FROM Student", Student.class).getResultList();

        fromStudent.forEach(System.out::println);

        em.getTransaction().commit();


    }
}