package bg.softuni.jsonxsmlexercise.domein.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class ProductSoldWithCountDTO {
    private Integer count;

    List<ProductBasicInfoModel> products;

    static ProductSoldWithCountDTO toProductSoldWithCountDTO(List<ProductBasicInfoModel> products) {
        return new ProductSoldWithCountDTO(products.size(),products);
    }
}
