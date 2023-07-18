package bg.softuni.jsonxsmlexercise.services;

import bg.softuni.jsonxsmlexercise.domein.models.user.UserModel;
import bg.softuni.jsonxsmlexercise.domein.models.user.UserWithSoldProducts;
import bg.softuni.jsonxsmlexercise.domein.models.user.UserWithSoldProductsModel;
import bg.softuni.jsonxsmlexercise.domein.models.user.UsersWithSoldProductsWrapperModel;
import bg.softuni.jsonxsmlexercise.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

import static bg.softuni.jsonxsmlexercise.constant.Paths.FOURTH_JSON_PATH;
import static bg.softuni.jsonxsmlexercise.constant.Paths.SECOND_JSON_PATH;
import static bg.softuni.jsonxsmlexercise.constant.Utils.MAPPER;
import static bg.softuni.jsonxsmlexercise.constant.Utils.writeIntoJsonFile;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserWithSoldProductsModel> getSuccessfulUser() throws IOException {
        List<UserWithSoldProductsModel> users = userRepository
                .findAllBySellingProductsBuyerIsNotNullOrderBySellingProductsBuyerLastNameAscSellingProductsBuyerFirstName()
                .stream().map(u -> MAPPER.map(u, UserWithSoldProductsModel.class))
                .toList();

        writeIntoJsonFile(users,SECOND_JSON_PATH);

        return users;
    }

    @Override
    public UsersWithSoldProductsWrapperModel getSuccessfulUser2() throws IOException {
        List<UserWithSoldProducts> usersWithSoldProducts = userRepository
                .findAllBySellingProductsBuyerIsNotNullOrderBySellingProductsBuyerLastNameAscSellingProductsBuyerFirstName()
                .stream().map(u -> MAPPER.map(u, UserModel.class))
                .map(UserModel::toUserWithProductModel)
                .toList();

        UsersWithSoldProductsWrapperModel response = new UsersWithSoldProductsWrapperModel(usersWithSoldProducts);


        writeIntoJsonFile(response,FOURTH_JSON_PATH);


        return response;
    }
}
