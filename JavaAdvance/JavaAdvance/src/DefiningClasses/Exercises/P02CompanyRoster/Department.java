package DefiningClasses.Exercises.P02CompanyRoster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Employee> employees;



    public Department(String name){
        this.name = name;
        employees = new ArrayList<>();
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public double calculateAverageSalary(){
        return this.employees.stream().mapToDouble(Employee::getSalary).average().orElse(0);
    }
}
