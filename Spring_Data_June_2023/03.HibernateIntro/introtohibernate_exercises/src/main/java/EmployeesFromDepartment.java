import entities.Employee;

import javax.persistence.EntityManager;

public class EmployeesFromDepartment {
    private static final String PRINT_FORMAT = "%s %s from Research and Development - $%.2f\n";
    public static void main(String[] args) {
        EntityManager entityManager = Utils.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.createQuery("FROM Employee where department.name = : dName ORDER BY salary, id",
                        Employee.class)
                .setParameter("dName", "Research and Development")
                .getResultList()
                .forEach(employee -> employee.printFormatFullNameDepNameAndSalary());

        entityManager.getTransaction().commit();

    }
}
