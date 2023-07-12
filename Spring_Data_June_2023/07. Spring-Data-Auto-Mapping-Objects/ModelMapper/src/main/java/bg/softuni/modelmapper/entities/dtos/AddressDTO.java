package bg.softuni.modelmapper.entities.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {
    private String country;

    private String city;

    public AddressDTO(String country, String city) {
        this.country = country;
        this.city = city;
    }
}
