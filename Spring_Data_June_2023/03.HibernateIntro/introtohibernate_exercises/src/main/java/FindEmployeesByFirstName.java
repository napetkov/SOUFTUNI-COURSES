import entities.Employee;

import javax.swing.*;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FindEmployeesByFirstName {
    public static void main(String[] args) {
        final String pattern = new Scanner(System.in).nextLine();


        Utils.createEntityManager()
                .createQuery("FROM Employee ", Employee.class)
                .getResultList().stream()
                .filter(employee -> employee.getFirstName().toLowerCase().startsWith(pattern.toLowerCase()))
                .toList()
                .forEach(Employee::printFullNameJobTitleSalary);

    }
}
