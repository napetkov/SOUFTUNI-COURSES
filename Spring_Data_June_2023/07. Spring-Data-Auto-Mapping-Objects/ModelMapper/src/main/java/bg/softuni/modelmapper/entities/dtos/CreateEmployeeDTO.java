package bg.softuni.modelmapper.entities.dtos;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
public class CreateEmployeeDTO {
    private final String firstName;
    private final String lastName;
    private final BigDecimal salary;
    private final LocalDate birthday;
    private final AddressDTO address;

    public CreateEmployeeDTO(String firstName, String lastName, BigDecimal salary, LocalDate birthday, AddressDTO address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.birthday = birthday;
        this.address = address;
    }


}
