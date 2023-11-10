package org.softuni.pathfinder.service.impl;

import org.modelmapper.ModelMapper;
import org.softuni.pathfinder.exceptions.UserNotFoundException;
import org.softuni.pathfinder.models.User;
import org.softuni.pathfinder.models.dto.view.UserProfileViewModel;
import org.softuni.pathfinder.reposritory.UserRepository;
import org.softuni.pathfinder.service.UserService;
import org.softuni.pathfinder.service.session.LoggedUser;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final LoggedUser loggedUser;
    private final ModelMapper modelMapper;


    public UserServiceImpl(UserRepository userRepository,
                           LoggedUser loggedUser,
                           ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
        this.modelMapper = modelMapper;
    }

    @Override
    public User getLoggedUser() {
        return userRepository.findByUsername(loggedUser.getUsername()).get();
    }

    @Override
    public UserProfileViewModel getUserProfile() {
        String username = loggedUser.getUsername();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User with username: " + username + "was not found!"));

        return    modelMapper.map(user, UserProfileViewModel.class);
    }
}
