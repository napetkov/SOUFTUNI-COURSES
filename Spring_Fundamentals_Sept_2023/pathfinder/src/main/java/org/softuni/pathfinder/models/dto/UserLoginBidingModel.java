package org.softuni.pathfinder.models.dto;

public class UserLoginBidingModel {
    private String username;
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
