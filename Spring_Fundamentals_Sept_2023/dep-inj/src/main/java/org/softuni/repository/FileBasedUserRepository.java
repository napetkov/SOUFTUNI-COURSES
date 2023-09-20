package org.softuni.repository;

import org.softuni.model.User;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class FileBasedUserRepository implements UserRepository{
    @Override
    public List<User> findAll() {
        return new BufferedReader(
                new InputStreamReader(ClassLoader.getSystemResourceAsStream("users.cvs")))
                .lines().map(this::parseUser).toList();
    }

    private User parseUser(String line){
        String[] token = line.split(",");
        return new User(token[0],token[1], Integer.parseInt(token[2]));
    }
}
