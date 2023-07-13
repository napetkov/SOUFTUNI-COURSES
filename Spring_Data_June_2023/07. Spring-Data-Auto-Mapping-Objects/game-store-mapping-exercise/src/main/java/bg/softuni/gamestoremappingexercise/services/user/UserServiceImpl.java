package bg.softuni.gamestoremappingexercise.services.user;

import bg.softuni.gamestoremappingexercise.domain.entities.User;
import bg.softuni.gamestoremappingexercise.domain.models.UserLoginDto;
import bg.softuni.gamestoremappingexercise.domain.models.UserRegisterDto;
import bg.softuni.gamestoremappingexercise.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static bg.softuni.gamestoremappingexercise.constants.ErrorMassages.EMAIL_ALREADY_EXIST;

@Service
public class UserServiceImpl implements UserService {
    private User loggedInUser;

    private final UserRepository userRepository;
    private final ModelMapper mapper;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public String registerUser(String[] args) {
        int argsLength = args.length;

        final String email = argsLength > 1 ? args[1] : "";
        final String password = argsLength > 2 ? args[2]: "";
        final String confirmPassword = argsLength > 3 ? args[3] : "";
        final String fullName = argsLength > 4 ? args[4]: "";

        UserRegisterDto userRegisterDTO;
        try {
            userRegisterDTO = new UserRegisterDto(email, password, confirmPassword, fullName);
        }catch (IllegalArgumentException exception){
            return exception.getMessage();
        }

        if (this.userRepository.findFirstByEmail(userRegisterDTO.getEmail()).isPresent()) {
            return EMAIL_ALREADY_EXIST;
        }

        final User user = this.mapper.map(userRegisterDTO, User.class);

        if (userRepository.count() == 0) {
            user.setIsAdmin(true);
        }else {
            user.setIsAdmin(false);
        }


        this.userRepository.saveAndFlush(user);

        return userRegisterDTO.successfullyRegisteredUser();
    }

    @Override
    public String loginUser(String[] args) {
        int argsLength = args.length;

        final String email = argsLength > 1 ? args[1] : "";
        final String password = argsLength > 2 ? args[2]: "";

        Optional<User> userToBeLogged = this.userRepository.findFirstByEmail(email);

        if (userToBeLogged.isEmpty()) return "Incorrect username.";

        UserLoginDto userLoginDto = new UserLoginDto(email, password);

        try {
            userLoginDto.validate(userToBeLogged.get().getPassword());

        }catch (IllegalArgumentException exception){
            return exception.getMessage();
        }


         this.loggedInUser = userToBeLogged.get();

        return null;
    }
}
