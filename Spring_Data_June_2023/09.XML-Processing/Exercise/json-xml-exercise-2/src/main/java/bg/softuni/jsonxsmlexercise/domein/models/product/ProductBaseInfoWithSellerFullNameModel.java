package bg.softuni.jsonxsmlexercise.domein.models.product;

import bg.softuni.jsonxsmlexercise.domein.entities.Product;
import com.google.gson.annotations.SerializedName;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductBaseInfoWithSellerFullNameModel {

    @XmlAttribute(name = "name")
    private String name;

    @XmlAttribute(name = "price")
    private BigDecimal price;

    @SerializedName(value = "seller")
    @XmlAttribute(name = "seller")
    private String sellerFirstName;

    public static ProductBaseInfoWithSellerFullNameModel getFromProduct(Product product){
        String sellerFullName = product.getSeller().getFirstName() + " " + product.getSeller().getLastName();

        return new ProductBaseInfoWithSellerFullNameModel(product.getName(),product.getPrice(), sellerFullName);
    }



}
