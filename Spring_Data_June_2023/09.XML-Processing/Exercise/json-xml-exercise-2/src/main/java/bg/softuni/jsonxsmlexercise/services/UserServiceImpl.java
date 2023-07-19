package bg.softuni.jsonxsmlexercise.services;

import bg.softuni.jsonxsmlexercise.domein.models.user.UserModel;
import bg.softuni.jsonxsmlexercise.domein.models.user.UserWithSoldProducts;
import bg.softuni.jsonxsmlexercise.domein.models.user.UserWithSoldProductsModel;
import bg.softuni.jsonxsmlexercise.domein.models.user.wrappers.UsersWithSoldProductsWrapperModel;
import bg.softuni.jsonxsmlexercise.domein.models.user.wrappers.UserWithSoldProductsWrapperModel;
import bg.softuni.jsonxsmlexercise.repositories.UserRepository;
import jakarta.xml.bind.JAXBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

import static bg.softuni.jsonxsmlexercise.constant.Paths.*;
import static bg.softuni.jsonxsmlexercise.constant.Utils.*;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserWithSoldProductsModel> getUsersAndSoldProducts() throws IOException, JAXBException {
        final List<UserWithSoldProductsModel> users = userRepository
                .findAllBySellingProductsBuyerIsNotNullOrderBySellingProductsBuyerLastNameAscSellingProductsBuyerFirstName()
                .stream().map(u -> MAPPER.map(u, UserWithSoldProductsModel.class))
                .toList();

        final UserWithSoldProductsWrapperModel wrapper = new UserWithSoldProductsWrapperModel(users);

        writeIntoXmlFile(wrapper,SECOND_XML_PATH);
        writeIntoJsonFile(users,SECOND_JSON_PATH);

        return users;
    }

    @Override
    public UsersWithSoldProductsWrapperModel getUsersAndSoldProductsWrapper() throws IOException, JAXBException {
        List<UserWithSoldProducts> usersWithSoldProducts = userRepository
                .findAllBySellingProductsBuyerIsNotNullOrderBySellingProductsBuyerLastNameAscSellingProductsBuyerFirstName()
                .stream().map(u -> MAPPER.map(u, UserModel.class))
                .map(UserModel::toUserWithProductModel)
                .toList();

        UsersWithSoldProductsWrapperModel wrapper = new UsersWithSoldProductsWrapperModel(usersWithSoldProducts);


        writeIntoJsonFile(wrapper,FOURTH_JSON_PATH);
        writeIntoXmlFile(wrapper,FOURTH_XML_PATH);

        return wrapper;
    }
}
