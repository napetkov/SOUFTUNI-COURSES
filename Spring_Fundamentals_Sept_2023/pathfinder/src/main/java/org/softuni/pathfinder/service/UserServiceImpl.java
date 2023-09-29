package org.softuni.pathfinder.service;

import org.softuni.pathfinder.models.User;
import org.softuni.pathfinder.reposritory.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<User> getALL() {
        return this.userRepository.findAll();
    }
}
