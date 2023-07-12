package bg.softuni.modelmapper.entities.dtos;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class EmployeeDTO {
    private String firstName;

    private BigDecimal salary;

    private String addressCity;

    public EmployeeDTO() {
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "firstName='" + firstName + '\'' +
                ", salary=" + salary +
                ", city='" + addressCity + '\'' +
                '}';
    }
}
