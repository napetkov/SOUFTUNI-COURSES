package bg.softuni.gamestoremappingexercise.domain.models;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class DetailGameDto {
    private String title;
    private String trailer;
    private String imageThumbnail;
    private float size;
    private BigDecimal price;
    private String description;
    private LocalDate releaseDate;

    public DetailGameDto() {
    }

    public DetailGameDto(String title, String trailer, String imageThumbnail, float size, BigDecimal price, String description, LocalDate releaseDate) {
        this.title = title;
        this.trailer = trailer;
        this.imageThumbnail = imageThumbnail;
        this.size = size;
        this.price = price;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {


        return String.format("Title: %s\n" +
                "Price: %s\n" +
                "Description: %s\n" +
                "Release date: %s\n",this.title,this.price,this.description,this.releaseDate);
    }
}
