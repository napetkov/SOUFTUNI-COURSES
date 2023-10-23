package com.plannerapp.service.impl;

import com.plannerapp.model.dto.user.UserLoginBindingModel;
import com.plannerapp.model.dto.user.UserRegisterBidingModel;
import com.plannerapp.model.entity.User;
import com.plannerapp.repo.UserRepository;
import com.plannerapp.service.LoggedUser;
import com.plannerapp.service.UserService;
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
    public boolean register(UserRegisterBidingModel userRegisterBidingModel) {
        if(!userRegisterBidingModel.getPassword().equals(userRegisterBidingModel.getConfirmPassword())){
            return false;
        }

        User dbUser = userRepository.findByUsernameOrEmail(userRegisterBidingModel.getUsername(),userRegisterBidingModel.getEmail());

        if(dbUser != null){
            return false;
        }

        User user = new User();

        user.setUsername(userRegisterBidingModel.getUsername())
                .setEmail(userRegisterBidingModel.getEmail())
                .setPassword(passwordEncoder.encode(userRegisterBidingModel.getPassword()));

        userRepository.save(user);

        return true;
    }

    @Override
    public boolean login(UserLoginBindingModel userLoginBindingModel) {
        String username = userLoginBindingModel.getUsername();
        User user = userRepository.findByUsername(username);

        if(user != null && passwordEncoder.matches(userLoginBindingModel.getPassword(),user.getPassword())){
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
