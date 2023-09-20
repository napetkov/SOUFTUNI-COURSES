package org.softuni.service;

import org.softuni.model.User;
import org.softuni.repository.InMemoryUserRepository;
import org.softuni.repository.UserRepository;

import java.util.Comparator;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findYoungestUser() {
        return userRepository.findAll()
                .stream().min(Comparator.comparing(User::age));
    }
}
