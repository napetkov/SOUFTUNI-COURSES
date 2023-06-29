import entities.Department;
import entities.Employee;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class EmployeesMaximumSalaries {
    public static final String PRINT_FORMAT_DEPARTMENT_MAX_SALARY = "%s %.2f";
    public static void main(String[] args) {


        final List<Department> depsWithEmplSalaryBetween30000And70000 = Utils.createEntityManager()
                .createQuery("FROM Department ", Department.class)
                .getResultList()
                .stream().filter(department -> department.getEmployees()
                .stream()
                .anyMatch(employee -> employee.getSalary().compareTo(BigDecimal.valueOf(30000)) > 0
                        && employee.getSalary().compareTo(BigDecimal.valueOf(70000)) > 0)).toList();

        depsWithEmplSalaryBetween30000And70000.forEach(department -> {
            BigDecimal maxSalary = department
                    .getEmployees()
                    .stream().map(Employee::getSalary)
                    .max(BigDecimal::compareTo).get();
            System.out.printf(PRINT_FORMAT_DEPARTMENT_MAX_SALARY,department.getName(),maxSalary);
        });

    }
}
