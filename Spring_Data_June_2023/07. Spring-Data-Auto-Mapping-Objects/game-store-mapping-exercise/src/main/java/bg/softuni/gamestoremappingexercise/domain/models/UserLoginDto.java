package bg.softuni.gamestoremappingexercise.domain.models;

import lombok.Getter;
import lombok.Setter;

import static bg.softuni.gamestoremappingexercise.constants.ErrorMassages.PASS_MISS_MATCH;

@Getter
@Setter

public class UserLoginDto {
    private final String username;
    private final String password;

    public UserLoginDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void validate(String realPassword) {
        if (!this.password.equals(realPassword)) {
            throw new IllegalArgumentException(PASS_MISS_MATCH);
        }
    }

    public String successfullyLogged(){
        return String.format("Successfully logged in %s",this.username);
    }
}
