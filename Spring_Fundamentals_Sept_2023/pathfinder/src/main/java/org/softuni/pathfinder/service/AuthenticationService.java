package org.softuni.pathfinder.service;

import org.softuni.pathfinder.models.dto.binding.UserLoginBidingModel;
import org.softuni.pathfinder.models.dto.binding.UserRegisterBindingModel;

public interface AuthenticationService {
    void register(UserRegisterBindingModel userRegisterBindingModel);

    boolean login(UserLoginBidingModel userLoginBidingModel);

    void logout();

}
