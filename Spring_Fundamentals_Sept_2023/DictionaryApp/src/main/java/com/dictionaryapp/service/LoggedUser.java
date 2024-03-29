package com.dictionaryapp.service;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
@Component
public class LoggedUser {
    private String username;
    private boolean isLogged;

    public String getUsername() {
        return username;
    }

    public LoggedUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public LoggedUser setLogged(boolean logged) {
        isLogged = logged;
        return this;
    }

    public void login(String username) {
        this.username = username;
        this.isLogged = true;
    }

    public void logout() {
        this.username = null;
        this.isLogged = false;
    }

}
