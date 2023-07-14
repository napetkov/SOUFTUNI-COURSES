package bg.softuni.gamestoremappingexercise.domain.models;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class AllGameDto {
    private String title;
    private BigDecimal price;

    public AllGameDto() {
    }

    public AllGameDto(String title, BigDecimal price) {
        this.title = title;
        this.price = price;
    }

    @Override
    public String toString() {
        return  this.title + " " + this.price;
    }
}
