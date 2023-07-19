package bg.softuni.jsonxsmlexercise.domein.models.product;

import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "sold-products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductSoldWithCountModel {

    @XmlAttribute(name = "count")
    private Integer count;

    @XmlElement(name = "product")
    List<ProductBasicInfoModel> products;

    static ProductSoldWithCountModel toProductSoldWithCountDTO(List<ProductBasicInfoModel> products) {
        return new ProductSoldWithCountModel(products.size(),products);
    }
}
