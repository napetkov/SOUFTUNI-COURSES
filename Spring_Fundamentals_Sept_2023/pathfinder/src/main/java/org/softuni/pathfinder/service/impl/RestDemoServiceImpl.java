package org.softuni.pathfinder.service.impl;

import org.softuni.pathfinder.models.User;
import org.softuni.pathfinder.reposritory.UserRepository;
import org.softuni.pathfinder.service.RestDemoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestDemoServiceImpl implements RestDemoService {
    private final UserRepository userRepository;

    public RestDemoServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<User> getALL() {
        return this.userRepository.findAll();
    }
}
