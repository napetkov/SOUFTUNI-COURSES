package bg.softuni.gamestoremappingexercise;

import bg.softuni.gamestoremappingexercise.services.game.GameService;
import bg.softuni.gamestoremappingexercise.services.order.OrderService;
import bg.softuni.gamestoremappingexercise.services.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

import static bg.softuni.gamestoremappingexercise.constants.Commands.*;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private static final Scanner SCANNER = new Scanner(System.in);

    private final UserService userService;
    private final GameService gameService;

    private final OrderService orderService;

    public ConsoleRunner(UserService userService, GameService gameService, OrderService orderService) {
        this.userService = userService;
        this.gameService = gameService;
        this.orderService = orderService;
    }

    @Override
    public void run(String... args) throws Exception {
        String input;

        while (!(input = SCANNER.nextLine()).equals(CLOSE)){
            final String[] arguments = input.split("\\|");
            final String command = arguments[0];

            final String output = switch (command){
                case REGISTER_USER -> userService.registerUser(arguments);
                case LOG_IN_USER -> userService.loginUser(arguments);
                case LOGOUT_USER -> userService.logoutUser();
                case ADD_GAME -> gameService.addGame(arguments);
                case EDIT_GAME -> gameService.editGame(arguments);
                case DELETE_GAME -> gameService.deleteGame(arguments);
                case PRINT_ALL_GAMES_WITH_PRICE -> gameService.printAllGames();
                case PRINT_GAME_DETAILS -> gameService.printGameDetails(arguments);
//                case PRINT_OWNED_GAME -> userService.printOwnedGames();
                case ADD_ITEM_TO_CART -> orderService.addItem(arguments);
                case REMOVE_ITEM_FROM_CART -> orderService.removeItem(arguments);
                case BUY_ITEM -> orderService.buyItem();

                default -> "No command found";
            };

            System.out.println(output);

        }



    }

    private String toDo() {
        return "";
    }
}
