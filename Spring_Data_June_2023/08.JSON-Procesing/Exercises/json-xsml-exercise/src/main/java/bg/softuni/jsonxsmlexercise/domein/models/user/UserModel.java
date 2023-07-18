package bg.softuni.jsonxsmlexercise.domein.models.user;

import bg.softuni.jsonxsmlexercise.domein.entities.BaseEntity;
import bg.softuni.jsonxsmlexercise.domein.models.product.ProductDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter

public class UserModel extends BaseEntity {
    private String firstName;

    private String lastName;

    private Long age;

    private Set<ProductDTO> sellingProducts;

    public UserWithSoldProducts toUserWithProductModel() {
        return new UserWithSoldProducts(firstName,lastName,age, ProductDTO.toProductSoldWithCountDTO(sellingProducts));
    }
}
