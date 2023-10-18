package com.resellerapp.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;

public class UserLoginBidingModel {
    @Length(min = 3, max = 20)
    private String username;

    @Length(min = 3, max = 20)
    private String password;


    public String getUsername() {
        return username;
    }

    public UserLoginBidingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginBidingModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
