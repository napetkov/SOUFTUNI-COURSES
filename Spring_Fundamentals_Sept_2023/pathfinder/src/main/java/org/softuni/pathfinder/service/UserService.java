package org.softuni.pathfinder.service;

import org.softuni.pathfinder.models.User;
import org.softuni.pathfinder.models.dto.view.UserProfileViewModel;

public interface UserService {
    User getLoggedUser();
    boolean isUniqueUsername(String value);

    boolean isUniqueEmail(String value);
    UserProfileViewModel getUserProfile();
}
