import entities.Employee;

import javax.persistence.EntityManager;

public class EmployeesFromDepartment {
    public static void main(String[] args) {
        Utils.createEntityManager("soft_uni")
                .createQuery("FROM Employee where department.name = : dName ORDER BY salary, id",
                        Employee.class)
                .setParameter("dName", "Research and Development")
                .getResultList()
                .forEach(employee -> System.out.println(employee.getPrintFormatFullNameDepNameAndSalary()));

    }
}
