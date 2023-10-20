package com.plannerapp.service;

import com.plannerapp.model.dto.user.UserLoginBindingModel;
import com.plannerapp.model.dto.user.UserRegisterBidingModel;

public interface UserService {

    boolean register(UserRegisterBidingModel userRegisterBidingModel);

    boolean login(UserLoginBindingModel userLoginBindingModel);

    void logout();
}
