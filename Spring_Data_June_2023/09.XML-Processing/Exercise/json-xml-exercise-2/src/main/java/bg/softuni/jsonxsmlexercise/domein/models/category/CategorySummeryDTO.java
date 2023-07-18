package bg.softuni.jsonxsmlexercise.domein.models.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CategorySummeryDTO {

    private String category;
    private Long productCount;
    private Double averagePrice;
    private BigDecimal totalRevenue;

    public CategorySummeryDTO(String category, Long productCount, Double averagePrice, BigDecimal totalRevenue) {
        this.category = category;
        this.productCount = productCount;
        this.averagePrice = averagePrice;
        this.totalRevenue = totalRevenue;
    }
}
