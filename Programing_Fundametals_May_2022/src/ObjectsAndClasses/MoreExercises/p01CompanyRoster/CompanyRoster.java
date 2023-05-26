package ObjectsAndClasses.MoreExercises.p01CompanyRoster;

import java.util.List;

public class CompanyRoster {
    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private String age;


    public CompanyRoster(String name,double salary,String position,String department,String email,String age){
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;

    }

    public String getEmail() {
        return this.email;
    }

    public String getAge() {
        return this.age;
    }

    public double getSalary() {
        return this.salary;
    }

    public String getDepartment() {
        return this.department;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %s",this.name,this.salary,this.email,this.age);
    }
}


