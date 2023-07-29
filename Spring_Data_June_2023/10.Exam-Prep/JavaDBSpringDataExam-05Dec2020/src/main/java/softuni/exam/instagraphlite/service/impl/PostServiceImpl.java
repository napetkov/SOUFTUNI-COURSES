package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dto.PostsImportWrapperDto;
import softuni.exam.instagraphlite.models.entity.Picture;
import softuni.exam.instagraphlite.models.entity.Post;
import softuni.exam.instagraphlite.models.entity.User;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.repository.PostRepository;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.PostService;
import softuni.exam.instagraphlite.util.ValidationUtils;
import softuni.exam.instagraphlite.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static softuni.exam.instagraphlite.models.Constants.*;

@Service
public class PostServiceImpl implements PostService {
    private final String POSTS_FILE_PATH = "src/main/resources/files/posts.xml";
    private final UserRepository userRepository;
    private final PictureRepository pictureRepository;
    private final PostRepository postRepository;

    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;

    private final ValidationUtils validationUtils;

    public PostServiceImpl(UserRepository userRepository, PictureRepository pictureRepository, PostRepository postRepository, Gson gson, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtils validationUtils) {
        this.userRepository = userRepository;
        this.pictureRepository = pictureRepository;
        this.postRepository = postRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return this.postRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(POSTS_FILE_PATH));
    }

    @Override
    public String importPosts() throws IOException, JAXBException {
        StringBuilder stringBuilder = new StringBuilder();

        xmlParser.fromFile(Path.of(POSTS_FILE_PATH).toFile(), PostsImportWrapperDto.class)
                .getPosts()
                .stream().filter(postImportDto -> {
                    boolean isValid = validationUtils.isValid(postImportDto);

                    if (this.pictureRepository.findByPath(postImportDto.getPicture().getPath()).isEmpty()
                            || this.userRepository.findByUsername(postImportDto.getUser().getUsername()).isEmpty())
                        isValid = false;

                    stringBuilder.append(isValid
                            ? String.format(SUCCESSFUL_FORMAT, POST, "made by", postImportDto.getUser().getUsername())
                            : String.format(INVALID_FORMAT, POST));

                    stringBuilder.append(System.lineSeparator());

                    return isValid;
                })
                .map(post ->{
                    User user = this.userRepository.findByUsername(post.getUser().getUsername()).get();
                    Picture picture = this.pictureRepository.findByPath(post.getPicture().getPath()).get();

                    Post postToSave = modelMapper.map(post, Post.class);

                    postToSave.setUser(user);
                    postToSave.setPicture(picture);

                    return postToSave;
                })
                .forEach(this.postRepository::save);

        return stringBuilder.toString().trim();
    }
}
