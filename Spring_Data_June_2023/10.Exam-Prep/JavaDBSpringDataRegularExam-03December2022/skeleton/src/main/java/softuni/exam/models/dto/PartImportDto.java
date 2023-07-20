package softuni.exam.models.dto;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class PartImportDto {

    @NotNull
    @Size(min = 2, max = 19)
    private String partName;

    @NotNull
    @DecimalMin(value = "10.00")
    @DecimalMax(value = "2000.00")
    private Double price;

    @NotNull
    @Positive
    private Integer quantity;



    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
