package bg.softuni.gamestoremappingexercise.services.order;

import bg.softuni.gamestoremappingexercise.domain.entities.Game;
import bg.softuni.gamestoremappingexercise.domain.entities.User;
import bg.softuni.gamestoremappingexercise.repositories.GameRepository;
import bg.softuni.gamestoremappingexercise.services.user.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class OrderServiceImpl implements OrderService {
    private final GameRepository gameRepository;
    private final UserService userService;

    public OrderServiceImpl(GameRepository gameRepository, UserService userService) {
        this.gameRepository = gameRepository;
        this.userService = userService;
    }


    @Override
    public String addItem(String[] args) {
            String gameTitle = args[1];

        Optional<Game> gameByTitle = gameRepository.findFirstByTitle(gameTitle);

        if (gameTitle.isEmpty()) return "No such game in store.";

        if (userService.isLoggedInUser()) return "No logged in user.";

        User loggedInUser = userService.getLoggedInUser();

//        TODO: implement all method functionality


        return null;
    }

    @Override
    public String removeItem(String[] args) {
        return null;
    }

    @Override
    public String buyItem() {
        return null;
    }
}
