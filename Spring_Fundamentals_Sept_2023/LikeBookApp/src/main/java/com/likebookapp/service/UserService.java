package com.likebookapp.service;

import com.likebookapp.model.dto.user.UserLoginBindingModel;
import com.likebookapp.model.dto.user.UserRegisterBindingModel;

public interface UserService {
    boolean register(UserRegisterBindingModel userRegisterBindingModel);

    boolean login(UserLoginBindingModel userLoginBindingModel);

    void logout();
}
