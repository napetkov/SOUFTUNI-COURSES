package bg.softuni.gamestoremappingexercise.services.user;

import bg.softuni.gamestoremappingexercise.domain.entities.User;
import bg.softuni.gamestoremappingexercise.domain.models.OwnedGamesDto;
import bg.softuni.gamestoremappingexercise.domain.models.UserLoginDto;
import bg.softuni.gamestoremappingexercise.domain.models.UserRegisterDto;
import bg.softuni.gamestoremappingexercise.repositories.GameRepository;
import bg.softuni.gamestoremappingexercise.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static bg.softuni.gamestoremappingexercise.constants.ErrorMassages.EMAIL_ALREADY_EXIST;

@Service
public class UserServiceImpl implements UserService {
    private User loggedInUser;

    private final UserRepository userRepository;
    private final GameRepository gameRepository;
    private final ModelMapper mapper;

    public UserServiceImpl(UserRepository userRepository, GameRepository gameRepository) {
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
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
        if(loggedInUser != null) return "User is already logged.";

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

        return userLoginDto.successfullyLogged();
    }

    @Override
    public String logoutUser() {
        if(loggedInUser == null) return "No user logged.";

        this.loggedInUser = null;

        return "Logout. Test Me.";
    }

    @Override
    public boolean isLoggedInUserAdmin(){
        return  this.loggedInUser != null && this.loggedInUser.getIsAdmin();
    }

    @Override
    public boolean isLoggedInUser(){
        return  this.loggedInUser != null;
    }

    @Override
    public User getLoggedInUser() {
        return loggedInUser;
    }

//    @Override
//    public String printOwnedGames() {
//        if (isLoggedInUser()) return "User is not logged in.";
//
//        StringBuilder sb = new StringBuilder();
//
//        gameRepository.findAllByUserId(this.loggedInUser.getId())
//                .stream().map(g -> mapper.map(g, OwnedGamesDto.class))
//                .forEach(og -> sb.append(og.toString()));
//
//
//        return sb.toString();
//    }
}
