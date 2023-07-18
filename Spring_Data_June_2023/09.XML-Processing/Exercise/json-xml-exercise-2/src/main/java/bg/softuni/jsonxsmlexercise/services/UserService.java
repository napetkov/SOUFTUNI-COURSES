package bg.softuni.jsonxsmlexercise.services;

import bg.softuni.jsonxsmlexercise.domein.models.user.UserWithSoldProductsModel;
import bg.softuni.jsonxsmlexercise.domein.models.user.UsersWithSoldProductsWrapperModel;
import jakarta.xml.bind.JAXBException;

import java.io.IOException;
import java.util.List;

public interface UserService {

    List <UserWithSoldProductsModel> getUsersAndSoldProducts() throws IOException, JAXBException;

    UsersWithSoldProductsWrapperModel getUsersAndSoldProductsWrapper() throws IOException;
}
