package com.likebookapp.service.impl;

import com.likebookapp.model.dto.user.UserLoginBindingModel;
import com.likebookapp.model.dto.user.UserRegisterBindingModel;
import com.likebookapp.model.entity.User;
import com.likebookapp.repository.UserRepository;
import com.likebookapp.service.LoggedUser;
import com.likebookapp.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class userServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final LoggedUser loggedUser;
    private final PasswordEncoder passwordEncoder;

    public userServiceImpl(UserRepository userRepository, LoggedUser loggedUser, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean register(UserRegisterBindingModel userRegisterBindingModel) {
        if (!userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())) {
            return false;
        }

        User dbUser = userRepository.findByUsernameOrEmail(userRegisterBindingModel.getUsername(),
                userRegisterBindingModel.getEmail());

        if (dbUser != null) {
            return false;
        }

        User user = new User();
        user.setUsername(userRegisterBindingModel.getUsername())
                .setEmail(userRegisterBindingModel.getEmail())
                .setPassword(passwordEncoder.encode(userRegisterBindingModel.getPassword()));

        userRepository.save(user);

        return true;
    }

    @Override
    public boolean login(UserLoginBindingModel userLoginBindingModel) {
        String username = userLoginBindingModel.getUsername();

        User user = userRepository.findByUsername(username);

        if (user != null && passwordEncoder.matches(userLoginBindingModel.getPassword(), user.getPassword())) {
            loggedUser.login(username);
            return true;
        }
        return false;
    }

    @Override
    public void logout() {
        this.loggedUser.logout();
    }

}
