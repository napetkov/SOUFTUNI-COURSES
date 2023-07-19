package bg.softuni.jsonxsmlexercise.domein.models.user;

import bg.softuni.jsonxsmlexercise.domein.models.product.ProductSoldWithCountModel;
import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserWithSoldProducts {

    @XmlAttribute(name = "first-name")
    private String firstName;

    @XmlAttribute(name = "last-name")
    private String lastName;

    @XmlAttribute(name = "age")
    private Long age;

    @XmlElement(name = "sold-products")
    private ProductSoldWithCountModel soldProducts;



}
