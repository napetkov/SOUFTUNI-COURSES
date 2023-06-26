import entities.Employee;

import javax.persistence.EntityManager;

public class EmployeesWithASalaryOver50000 {
    public static void main(String[] args) {
        EntityManager entityManager = Utils.createEntityManager("soft_uni");

        entityManager.getTransaction().begin();

        entityManager.createQuery("from Employee where salary > 50000", Employee.class)
                .getResultList()
                .forEach(e -> System.out.println(e.getFirstName()));
//                .stream().map(Employee::getFirstName)
//                .forEach(System.out::println);


        entityManager.getTransaction().commit();
    }
}
