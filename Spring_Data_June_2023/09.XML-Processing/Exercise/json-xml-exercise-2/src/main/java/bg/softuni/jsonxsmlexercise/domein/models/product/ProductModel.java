package bg.softuni.jsonxsmlexercise.domein.models.product;

import bg.softuni.jsonxsmlexercise.domein.entities.User;
import bg.softuni.jsonxsmlexercise.domein.models.category.CategoryModel;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class ProductModel {
    private String name;

    private BigDecimal price;

    private User buyer;

    private User seller;

    private Set<CategoryModel> categories;

    public static ProductSoldWithCountModel toProductSoldWithCountDTO(Set<ProductModel> sellingProducts) {
        List<ProductBasicInfoModel> productBasicInfoModelStream = sellingProducts.stream()
                .map(ProductModel::toProductBasicInfoModel)
                .toList();

        return ProductSoldWithCountModel.toProductSoldWithCountDTO (productBasicInfoModelStream);
    }

    private static ProductBasicInfoModel toProductBasicInfoModel(ProductModel productDTO) {
        return new ProductBasicInfoModel(productDTO.getName(),productDTO.getPrice());
    }
}

