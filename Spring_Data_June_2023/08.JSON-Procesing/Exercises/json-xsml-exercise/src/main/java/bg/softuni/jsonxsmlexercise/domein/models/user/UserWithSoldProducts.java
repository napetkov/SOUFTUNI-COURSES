package bg.softuni.jsonxsmlexercise.domein.models.user;

import bg.softuni.jsonxsmlexercise.domein.models.product.ProductSoldWithCountDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserWithSoldProducts {

    private String firstName;

    private String lastName;

    private Long age;

    private ProductSoldWithCountDTO soldProducts;



}