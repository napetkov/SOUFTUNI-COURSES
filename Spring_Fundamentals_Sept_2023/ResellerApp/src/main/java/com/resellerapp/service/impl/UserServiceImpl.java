package com.resellerapp.service.impl;

import com.resellerapp.model.UserLoginBidingModel;
import com.resellerapp.model.UserRegisterBindingModel;
import com.resellerapp.model.entity.User;
import com.resellerapp.repository.UserRepository;
import com.resellerapp.service.LoggedUser;
import com.resellerapp.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final LoggedUser loggedUser;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.loggedUser = loggedUser;
    }

    @Override
    public boolean register(UserRegisterBindingModel userRegisterBindingModel) {
        if (userRegisterBindingModel == null) {
            return false;
        }

        if (this.findUserByUsername(userRegisterBindingModel.getUsername()) != null) {
            return false;
        }
        ;

        User user = new User();
        user.setUsername(userRegisterBindingModel.getUsername())
                .setEmail(userRegisterBindingModel.getEmail())
                .setPassword(passwordEncoder.encode(userRegisterBindingModel.getPassword()));
        this.userRepository.save(user);
        return true;
    }

    @Override
    public boolean login(UserLoginBidingModel userLoginBidingModel) {
        User user = this.findUserByUsername(userLoginBidingModel.getUsername());

        if (user != null && passwordEncoder.matches(userLoginBidingModel.getPassword(), user.getPassword())) {
            loggedUser.setUsername(userLoginBidingModel.getUsername());
            loggedUser.setLogged(true);

            return true;
        }
        return false;
    }

    @Override
    public void logout() {
        loggedUser.setUsername(null);
        loggedUser.setLogged(false);
    }

    private User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
