package bg.softuni.jsonxsmlexercise.domein.models.product;

import bg.softuni.jsonxsmlexercise.domein.entities.Product;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class ProductBaseInfoWithSellerFullNameModel {

    private String name;

    private BigDecimal price;

    @SerializedName(value = "seller")
    private String sellerFirstName;

    public static ProductBaseInfoWithSellerFullNameModel getFromProduct(Product product){
        String sellerFullName = product.getSeller().getFirstName() + " " + product.getSeller().getLastName();

        return new ProductBaseInfoWithSellerFullNameModel(product.getName(),product.getPrice(), sellerFullName);
    }



}
