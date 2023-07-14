package bg.softuni.gamestoremappingexercise.domain.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OwnedGamesDto {
    private String title;

    public OwnedGamesDto() {
    }

    public OwnedGamesDto(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return this.title + System.lineSeparator();
    }
}
