package bg.softuni.jsonxsmlexercise.domein.models.user;

import bg.softuni.jsonxsmlexercise.domein.models.product.ProductSoldDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserWithSoldProductsModel {

    private String firstName;

    private String lastName;

    Set<ProductSoldDTO> boughtProducts;


}
