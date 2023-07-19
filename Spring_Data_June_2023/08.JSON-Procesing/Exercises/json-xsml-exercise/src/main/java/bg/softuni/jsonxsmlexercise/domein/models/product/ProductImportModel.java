package bg.softuni.jsonxsmlexercise.domein.models.product;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductImportModel {
    private String name;

    private BigDecimal price;
}