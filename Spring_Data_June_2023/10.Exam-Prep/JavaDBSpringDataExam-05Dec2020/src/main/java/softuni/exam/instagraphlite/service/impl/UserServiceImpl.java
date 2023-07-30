package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dto.ExportUsersWithPostDto;
import softuni.exam.instagraphlite.models.dto.UserImportDto;
import softuni.exam.instagraphlite.models.entity.Picture;
import softuni.exam.instagraphlite.models.entity.Post;
import softuni.exam.instagraphlite.models.entity.User;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.repository.PostRepository;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.UserService;
import softuni.exam.instagraphlite.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static softuni.exam.instagraphlite.models.Constants.*;

@Service
public class UserServiceImpl implements UserService {
    private final String USER_FILE_PATH = "src/main/resources/files/users.json";
    private final UserRepository userRepository;
    private final PictureRepository pictureRepository;
    private final PostRepository postRepository;

    private final Gson gson;

    private final ModelMapper modelMapper;

    private final ValidationUtils validationUtils;

    public UserServiceImpl(UserRepository userRepository, PictureRepository pictureRepository, PostRepository postRepository, Gson gson, ModelMapper modelMapper, ValidationUtils validationUtils) {
        this.userRepository = userRepository;
        this.pictureRepository = pictureRepository;
        this.postRepository = postRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return this.userRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(USER_FILE_PATH));
    }

    @Override
    public String importUsers() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        Arrays.stream(gson.fromJson(readFromFileContent(), UserImportDto[].class))
                .filter(userImportDto -> {
                    boolean isValid = validationUtils.isValid(userImportDto);

                    if (this.userRepository.findByUsername(userImportDto.getUsername()).isPresent()
                            ||this.pictureRepository.findByPath(userImportDto.getProfilePicture()).isEmpty()) isValid = false;

                    stringBuilder.append(isValid
                    ?String.format(SUCCESSFUL_FORMAT,USER+":",userImportDto.getUsername(),"")
                    :String.format(INVALID_FORMAT,USER));

                    stringBuilder.append(System.lineSeparator());

                    return isValid;
                })
                .map(user -> {
                    Picture picture = this.pictureRepository.findByPath(user.getProfilePicture()).get();
                    User userToSave = modelMapper.map(user, User.class);
                    userToSave.setPicture(picture);

                    return userToSave;
                })
                .forEach(this.userRepository::save);

        return stringBuilder.toString().trim();
    }

    @Override
    public String exportUsersWithTheirPosts() {




        return null;
    }
}
