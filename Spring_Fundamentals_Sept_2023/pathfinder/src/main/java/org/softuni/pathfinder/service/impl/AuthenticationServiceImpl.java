package org.softuni.pathfinder.service.impl;

import org.modelmapper.ModelMapper;
import org.softuni.pathfinder.models.User;
import org.softuni.pathfinder.models.dto.binding.UserLoginBidingModel;
import org.softuni.pathfinder.models.dto.binding.UserRegisterBindingModel;
import org.softuni.pathfinder.reposritory.UserRepository;
import org.softuni.pathfinder.service.AuthenticationService;
import org.softuni.pathfinder.service.session.LoggedUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final LoggedUser loggedUser;

    public AuthenticationServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.loggedUser = loggedUser;
    }

    @Override
    public void register(UserRegisterBindingModel userRegisterBindingModel) {
        User user = modelMapper.map(userRegisterBindingModel, User.class);

        user.setPassword(passwordEncoder.encode(userRegisterBindingModel.getPassword()));

        userRepository.save(user);
    }

    @Override
    public boolean login(UserLoginBidingModel userLoginBidingModel) {
        String username = userLoginBidingModel.getUsername();
        Optional<User> user = userRepository.findByUsername(username);

        if(user.isEmpty()){
            throw new IllegalArgumentException("User with username"+ username +"is not present!");
        }

        boolean passwordMatch = passwordEncoder.matches(userLoginBidingModel.getPassword(), user.get().getPassword());

        if(!passwordMatch){
            throw new IllegalArgumentException("User enter incorrect password");
        }

        loggedUser
                .setUsername(user.get().getUsername())
                .setEmail(user.get().getEmail())
                .setFullName(user.get().getFullName())
                .setLogged(true);

        return passwordMatch;
    }

    @Override
    public void logout() {
        loggedUser.reset();
    }
}
