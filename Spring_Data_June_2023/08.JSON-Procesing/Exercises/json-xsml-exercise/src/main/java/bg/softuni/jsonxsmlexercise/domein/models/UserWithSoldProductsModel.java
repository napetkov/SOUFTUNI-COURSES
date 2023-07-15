package bg.softuni.jsonxsmlexercise.domein.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class UserWithSoldProductsModel {

    private String firstName;

    private String lastName;

    Set<ProductSoldDTO> boughtProducts;


}
