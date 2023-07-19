package bg.softuni.jsonxsmlexercise.domein.models.user;

import bg.softuni.jsonxsmlexercise.domein.models.product.ProductSoldModel;
import bg.softuni.jsonxsmlexercise.domein.models.product.wrappers.SoldProductsWrapperXMLModel;
import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserWithSoldProductsModel {

    @XmlAttribute(name = "first-name")
    private String firstName;

    @XmlAttribute(name = "last-name")
    private String lastName;

    @XmlElement(name = "sold-products")
    SoldProductsWrapperXMLModel boughtProducts;


}
