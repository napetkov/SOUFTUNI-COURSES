package org.softuni.pathfinder.service;

import org.softuni.pathfinder.models.dto.UserLoginBidingModel;
import org.softuni.pathfinder.models.dto.UserRegisterBindingModel;

public interface UserService {
    void register(UserRegisterBindingModel userRegisterBindingModel);

    boolean login(UserLoginBidingModel userLoginBidingModel);

    void logout();

}
