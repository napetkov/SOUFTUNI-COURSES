package org.softuni.service;

import org.softuni.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface UserService {

    Optional<User> findYoungestUser();
}
