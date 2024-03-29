package com.resellerapp.model.dto.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRegisterBindingModel {
    @NotNull
    @Size(min = 3,max=20,message = "Username must be between 3 and 20 characters!")
    private String username;
    @Email
    @NotBlank(message = "Email can not be Empty!")
    private String email;
    @NotNull
    @Size(min = 3,max=20,message = "Password must be between 3 and 20 characters!")
    private String password;

    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
