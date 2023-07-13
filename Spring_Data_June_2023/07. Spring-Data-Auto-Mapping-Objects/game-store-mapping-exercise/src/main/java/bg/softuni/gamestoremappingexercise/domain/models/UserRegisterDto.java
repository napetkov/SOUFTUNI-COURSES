package bg.softuni.gamestoremappingexercise.domain.models;

import lombok.*;

import java.util.regex.Pattern;

import static bg.softuni.gamestoremappingexercise.constants.ErrorMassages.*;
import static bg.softuni.gamestoremappingexercise.constants.Validations.EMAIL_PATTERN;
import static bg.softuni.gamestoremappingexercise.constants.Validations.PASSWORD_PATTERN;


@Getter
@Setter
@Builder
@NoArgsConstructor
public class UserRegisterDto {


    private String email;
    private String password;
    private String confirmPassword;
    private String fullName;


    public UserRegisterDto(String email, String password, String confirmPassword, String fullName) {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.fullName = fullName;
        validate();
    }

    private void validate() {
        if (!Pattern.matches(EMAIL_PATTERN,this.email)) {
            throw new IllegalArgumentException(INVALID_EMAIL);
        }

        if (!Pattern.matches(PASSWORD_PATTERN,this.password)){
            throw new IllegalArgumentException(INVALID_PASSWORD);
        }


        if (!this.password.equals(this.confirmPassword)) {
            throw new IllegalArgumentException(PASS_MISS_MATCH);
        }
    }

    public String successfullyRegisteredUser(){
        return this.fullName + " was registered.";
    }


}


