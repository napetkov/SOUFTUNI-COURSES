package bg.softuni.gamestoremappingexercise.domain.models;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.regex.Pattern;

import static bg.softuni.gamestoremappingexercise.constants.ErrorMassages.*;
import static bg.softuni.gamestoremappingexercise.constants.Validations.*;

@Getter
@Setter
public class GameAddDto {
    private final String title;
    private final BigDecimal price;
    private final float size;
    private final String trailer;
    private final String imageThumbnail;
    private final String description;
    private final LocalDate releaseDate;

    public GameAddDto(String title, BigDecimal price, float size, String trailer, String imageThumbnail, String description, LocalDate releaseDate) {
        this.title = title;
        this.price = price;
        this.size = size;
        this.trailer = trailer;
        this.imageThumbnail = imageThumbnail;
        this.description = description;
        this.releaseDate = releaseDate;
        validate();
    }

    private void validate() {
        if (!Pattern.matches(ADD_GAME_TITLE_PATTERN,this.title)) {
            throw new IllegalArgumentException(GAME_TITTLE_IS_NOT_IN_REQUIREMENTS);
        }

        if(this.price.compareTo(BigDecimal.ZERO) <= 0){
            throw  new IllegalArgumentException(PRICE_MUST_BE_POSITIVE_NUMBER);
        }

        if(this.size < 0 ){
            throw  new IllegalArgumentException(SIZE_MUST_BE_POSITIVE_NUMBER);
        }

        if (!Pattern.matches(ADD_GAME_TRAILER_PATTERN,this.trailer)) {
            throw new IllegalArgumentException(GAME_TRAILER_IS_NOT_IN_REQUIREMENTS);
        }

        if (!Pattern.matches(ADD_GAME_THUMBNAIL_URL_PATTERN,this.imageThumbnail)) {
            throw new IllegalArgumentException(GAME_THUMBNAIL_URL_PATTERN_IS_NOT_IN_REQUIREMENTS);
        }

        if(this.description.length() < 20 ){
            throw  new IllegalArgumentException(DESCRIPTION_LENGTH_MUST_BE_AT_LAST_20_SYMBOLS);
        }




    }

    public String successfullyAddedGame(){
        return "Added" + " " + this.title;
    }

}
