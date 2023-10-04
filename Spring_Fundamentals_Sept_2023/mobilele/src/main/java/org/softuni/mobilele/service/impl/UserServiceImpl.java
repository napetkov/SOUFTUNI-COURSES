package org.softuni.mobilele.service.impl;

import org.softuni.mobilele.model.dto.UserLoginDTO;
import org.softuni.mobilele.model.dto.UserRegistrationDTO;
import org.softuni.mobilele.model.entity.UserEntity;
import org.softuni.mobilele.repository.UserRepository;
import org.softuni.mobilele.service.UserService;
import org.softuni.mobilele.util.CurrentUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.currentUser = currentUser;
    }

    public void registerUser(UserRegistrationDTO userRegistrationDTO) {
        userRepository.save(map(userRegistrationDTO));
//        System.out.println(userRegistrationDTO); // <--- ANTI pattern
    }

    @Override
    public boolean loginUser(UserLoginDTO userLoginDTO) {
        boolean loginSuccess = false;

        UserEntity userEntity = userRepository
                .findByEmail(userLoginDTO.email())
                .orElse(null);

        if(userEntity != null) {
            String encodedPassword = userEntity.getPassword();

            String rawPassword = userLoginDTO.password();

            loginSuccess = encodedPassword != null &&
                    passwordEncoder.matches(rawPassword, encodedPassword);

            if(loginSuccess){
                currentUser.setLogged(true)
                        .setFirstName(userEntity.getFirstName())
                        .setLastName(userEntity.getLastName());
            }else{
                currentUser.logout();
            }
        }


        return loginSuccess;
    }

    @Override
    public void logoutUser() {
        currentUser.logout();
    }

    private UserEntity map(UserRegistrationDTO userRegistrationDTO){
        return new UserEntity()
                .setActive(true)
                .setFirstName(userRegistrationDTO.firstName())
                .setLastName(userRegistrationDTO.lastName())
                .setEmail(userRegistrationDTO.email())
                .setPassword(passwordEncoder.encode(userRegistrationDTO.password()));

    }
}
