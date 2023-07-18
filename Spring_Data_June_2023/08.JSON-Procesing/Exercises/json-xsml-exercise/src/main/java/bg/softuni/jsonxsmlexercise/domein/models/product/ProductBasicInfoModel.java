package bg.softuni.jsonxsmlexercise.domein.models.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class ProductBasicInfoModel {

    private String name;

    private BigDecimal price;



}
