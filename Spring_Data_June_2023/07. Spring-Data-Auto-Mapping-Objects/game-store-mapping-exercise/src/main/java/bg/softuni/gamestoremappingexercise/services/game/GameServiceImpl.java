package bg.softuni.gamestoremappingexercise.services.game;

import bg.softuni.gamestoremappingexercise.domain.entities.Game;
import bg.softuni.gamestoremappingexercise.domain.models.GameDto;
import bg.softuni.gamestoremappingexercise.domain.models.GameEditDto;
import bg.softuni.gamestoremappingexercise.repositories.GameRepository;
import bg.softuni.gamestoremappingexercise.services.user.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {
    private final ModelMapper mapper = new ModelMapper();
    private final GameRepository gameRepository;
    private final UserService userService;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository, UserService userService) {
        this.gameRepository = gameRepository;
        this.userService = userService;
    }


    @Override
    public String addGame(String[] args) {
        if (!this.userService.isLoggedInUserAdmin()) return "Logged user is not admin";

        int argsLength = args.length;

        final String title = argsLength > 1 ? args[1] : "";
        final BigDecimal price = argsLength > 2 ? new BigDecimal(args[2]) : BigDecimal.ZERO;
        final float size = argsLength > 3 ? Float.parseFloat(args[3]) : Float.parseFloat("0.0");
        final String trailer = argsLength > 4 ? args[4] : "";
        final String thubnailURL = argsLength > 5 ? args[5] : "";
        final String description = argsLength > 6 ? args[6] : "";
        final LocalDate releaseDate = argsLength > 7 ? LocalDate.parse(args[7],DateTimeFormatter.ofPattern("dd-MM-yyyy")) : LocalDate.now();

        final GameDto gameDto = new GameDto(title, price, size, trailer, thubnailURL, description, releaseDate);

        Game gameToBeSaved = this.mapper.map(gameDto, Game.class);

        gameRepository.saveAndFlush(gameToBeSaved);


        return gameDto.successfullyAddedGame();
    }

    @Override
    public String deleteGame(String[] args) {
        if (!this.userService.isLoggedInUserAdmin()) return "Logged user is not admin";

        Long gameForUpdateId = Long.parseLong(args[1]);
        Optional<Game> gameToBeDeleted = this.gameRepository.findFirstById(gameForUpdateId);

        if (gameToBeDeleted.isEmpty()) return "No such Game!";

        this.gameRepository.delete(gameToBeDeleted.get());


        return "Deleted " + gameToBeDeleted.get().getTitle();
    }

    @Override
    public String editGame(String[] args) {
        if (!this.userService.isLoggedInUserAdmin()) return "Logged user is not admin";

        Long gameForUpdateId = Long.parseLong(args[1]);
        Optional<Game> gameToBeEdited = this.gameRepository.findFirstById(gameForUpdateId);

        if (gameToBeEdited.isEmpty()) return "No such Game!";


        Map<String, String> updatingArguments = new HashMap<>();

        for (int i = 2; i < args.length; i++) {

            updatingArguments.put(args[i].split("=")[0], args[i].split("=")[1]);
        }


        final GameEditDto gameEditDto = this.mapper.map(gameToBeEdited.get(), GameEditDto.class);

        gameEditDto.updateFields(updatingArguments);

        Game editedGame = this.mapper.map(gameEditDto, Game.class);

        this.gameRepository.saveAndFlush(editedGame);

        return gameEditDto.successfullyEditedGame();
    }
}
