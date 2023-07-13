package bg.softuni.gamestoremappingexercise.domain.models;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class GameDto {
    private final String title;
    private final BigDecimal price;
    private final float size;
    private final String trailer;
    private final String thubnailURL;
    private final String description;
    private final LocalDate releaseDate;

    public GameDto(String title, BigDecimal price, float size, String trailer, String thubnailURL, String description, LocalDate releaseDate) {
        this.title = title;
        this.price = price;
        this.size = size;
        this.trailer = trailer;
        this.thubnailURL = thubnailURL;
        this.description = description;
        this.releaseDate = releaseDate;
        validate();
    }

    private void validate() {
//        TODO: validate all field entries

    }

    public String successfullyAddedGame(){
        return "Added" + " " + this.title;
    }

}
