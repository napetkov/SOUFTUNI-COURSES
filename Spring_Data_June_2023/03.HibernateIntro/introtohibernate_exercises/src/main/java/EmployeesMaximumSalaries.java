import entities.Department;
import entities.Employee;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class EmployeesMaximumSalaries {
    public static final String PRINT_FORMAT_DEPARTMENT_MAX_SALARY = "%s %.2f\n";
    public static void main(String[] args) {


        final List<Object[]> departmentsNameAndMaxSalary = Utils.createEntityManager()
                .createQuery("SELECT department.name, max(salary) from Employee " +
                        "GROUP BY department.name " +
                        "HAVING max(salary) not between 30000 and 70000", Object[].class)
                .getResultList();

                departmentsNameAndMaxSalary
                        .forEach(department -> System.out.printf(PRINT_FORMAT_DEPARTMENT_MAX_SALARY,department[0],department[1]));

    }
}
