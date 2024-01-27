package com.resellerapp.service;

import com.resellerapp.model.dto.user.UserLoginBindingModel;
import com.resellerapp.model.dto.user.UserRegisterBindingModel;

public interface UserService {
    boolean register(UserRegisterBindingModel userRegisterBindingModel);

    boolean login(UserLoginBindingModel userLoginBindingModel);
    void logout();
}
