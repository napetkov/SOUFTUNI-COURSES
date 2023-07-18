package bg.softuni.jsonxsmlexercise.domein.models.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class ProductSoldWithCountModel {
    private Integer count;

    List<ProductBasicInfoModel> products;

    static ProductSoldWithCountModel toProductSoldWithCountDTO(List<ProductBasicInfoModel> products) {
        return new ProductSoldWithCountModel(products.size(),products);
    }
}
