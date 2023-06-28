import entities.Employee;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class IncreaseSalaries {
    public static final List<String> DEPARTMENTS_LIST_TO_INCREASE_SALARIES =
            List.of("Engineering",
                    "Tool Design",
                    "Marketing",
                    "Information Services");

    public static void main(String[] args) {

        EntityManager entityManager = Utils.createEntityManager();

        entityManager.getTransaction().begin();

        List<Employee> employeeList = entityManager.createQuery("FROM Employee WHERE department.name in (:deps)", Employee.class)
                .setParameter("deps", DEPARTMENTS_LIST_TO_INCREASE_SALARIES)
                .getResultList();

        employeeList.forEach(employee -> employee.setSalary(employee.getSalary()
                .multiply(BigDecimal.valueOf(1.12))));

        employeeList.forEach(Employee::printFullNameSalaryAfterIncreasing);

        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();


    }
}
