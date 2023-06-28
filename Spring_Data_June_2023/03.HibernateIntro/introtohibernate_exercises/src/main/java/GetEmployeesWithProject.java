import entities.Employee;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

public class GetEmployeesWithProject {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int employeeId = scanner.nextInt();

        EntityManager entityManager = Utils.createEntityManager();

        entityManager.getTransaction().begin();
        List<Employee> resultList = entityManager.createQuery("FROM Employee where id = : id", Employee.class)
                .setParameter("id", employeeId)
                .getResultList();

        if (!resultList.isEmpty()) {
            resultList.forEach(Employee::printFormatEmployeeWithProject);
        }

        entityManager.getTransaction().commit();
    }
}
