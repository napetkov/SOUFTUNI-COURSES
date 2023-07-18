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
public class ProductDTO {
    private String name;

    private BigDecimal price;

    private User buyer;

    private User seller;

    private Set<CategoryModel> categories;

    public static ProductSoldWithCountDTO toProductSoldWithCountDTO(Set<ProductDTO> sellingProducts) {
        List<ProductBasicInfoModel> productBasicInfoModelStream = sellingProducts.stream()
                .map(ProductDTO::toProductBasicInfoModel)
                .toList();

        return ProductSoldWithCountDTO.toProductSoldWithCountDTO (productBasicInfoModelStream);
    }

    private static ProductBasicInfoModel toProductBasicInfoModel(ProductDTO productDTO) {
        return new ProductBasicInfoModel(productDTO.getName(),productDTO.getPrice());
    }
}

