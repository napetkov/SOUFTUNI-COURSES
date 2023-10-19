package com.resellerapp.service;

import com.resellerapp.model.UserLoginBidingModel;
import com.resellerapp.model.UserRegisterBindingModel;

public interface UserService {
    boolean register(UserRegisterBindingModel userRegisterBindingModel);

    boolean login(UserLoginBidingModel userLoginBidingModel);

    void logout();
}
