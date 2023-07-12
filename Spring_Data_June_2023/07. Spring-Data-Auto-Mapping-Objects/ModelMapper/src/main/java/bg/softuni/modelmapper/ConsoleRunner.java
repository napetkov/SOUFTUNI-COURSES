package bg.softuni.modelmapper;

import bg.softuni.modelmapper.entities.Address;
import bg.softuni.modelmapper.entities.Employee;
import bg.softuni.modelmapper.entities.dtos.AddressDTO;
import bg.softuni.modelmapper.entities.dtos.CreateEmployeeDTO;
import bg.softuni.modelmapper.entities.dtos.EmployeeNameAndSalaryDTO;
import bg.softuni.modelmapper.services.AddressService;
import bg.softuni.modelmapper.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private final AddressService addressService;
    private final EmployeeService employeeService;

    private final Scanner scanner;

    @Autowired
    public ConsoleRunner(AddressService addressService, EmployeeService employeeService, Scanner scanner) {
        this.addressService = addressService;
        this.employeeService = employeeService;
        this.scanner = scanner;
    }

    @Override
    public void run(String... args) throws Exception {

//        createAddress(scanner);

//        createEmployee(scanner);

//        printAllEmployees();

//        printEmployeesNames();

        printEmployeeNameAndSalary();

    }

    private void printEmployeeNameAndSalary() {
        EmployeeNameAndSalaryDTO result = employeeService.findNameAndSalaryById(2L);

        System.out.println(result.getFirstName());
        System.out.println(result.getSalary());
    }

    private void printEmployeesNames() {
        System.out.println(employeeService.findNamesById(1L));
    }

    private void printAllEmployees() {
        this.employeeService.findAll()
                .forEach(System.out::println);

    }

    private void createEmployee() {
        String firstName = scanner.nextLine();
        BigDecimal salary = new BigDecimal(scanner.nextLine());
        LocalDate birthday = LocalDate.parse(scanner.nextLine());

//        long addressId = Long.parseLong(scanner.nextLine());
        String country = scanner.nextLine();
        String city = scanner.nextLine();
        AddressDTO address = new AddressDTO(country, city);

        CreateEmployeeDTO employDTO = new CreateEmployeeDTO(firstName, null, salary, birthday, address);

        Employee employee = this.employeeService.create(employDTO);

        System.out.println(employee);

    }

    private void createAddress() {
        String country = scanner.nextLine();

        String city = scanner.nextLine();

        AddressDTO data = new AddressDTO(country, city);

        Address address = addressService.create(data);

        System.out.println(address);
    }
}
