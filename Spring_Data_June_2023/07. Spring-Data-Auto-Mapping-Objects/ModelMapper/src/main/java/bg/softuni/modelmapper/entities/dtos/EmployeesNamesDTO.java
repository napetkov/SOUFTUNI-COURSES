package bg.softuni.modelmapper.entities.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeesNamesDTO {
    private String firstName;
    private String lastName;

    public EmployeesNamesDTO() {
    }

    public EmployeesNamesDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "EmployeesNamesDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
