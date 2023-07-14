package bg.softuni.gamestoremappingexercise.services.user;

import bg.softuni.gamestoremappingexercise.domain.entities.User;

public interface UserService {
    String registerUser(String[] args);

    String loginUser(String[] arguments);

    String logoutUser();

    boolean isLoggedInUserAdmin();

    boolean isLoggedInUser();

    User getLoggedInUser();

//    String printOwnedGames();
}
