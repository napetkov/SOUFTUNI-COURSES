package com.resellerapp.service;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
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
}
