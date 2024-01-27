package com.resellerapp.service.impl;

import com.resellerapp.model.dto.user.UserLoginBindingModel;
import com.resellerapp.model.dto.user.UserRegisterBindingModel;
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
        if(!userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())){
            return false;
        }

        User dbUser = userRepository.findByUsernameOrEmail(userRegisterBindingModel.getUsername(),
                userRegisterBindingModel.getEmail());

        if(dbUser != null){
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

        if(user != null && passwordEncoder.matches(userLoginBindingModel.getPassword(),
                user.getPassword())){
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
