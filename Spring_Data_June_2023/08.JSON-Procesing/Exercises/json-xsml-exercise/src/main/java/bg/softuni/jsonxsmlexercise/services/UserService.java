package bg.softuni.jsonxsmlexercise.services;

import bg.softuni.jsonxsmlexercise.domein.models.UserWithSoldProductsModel;
import bg.softuni.jsonxsmlexercise.domein.models.UsersWithSoldProductsWrapperModel;

import java.io.IOException;
import java.util.List;

public interface UserService {

    List<UserWithSoldProductsModel> getSuccessfulUser() throws IOException;

    UsersWithSoldProductsWrapperModel getSuccessfulUser2() throws IOException;
}
