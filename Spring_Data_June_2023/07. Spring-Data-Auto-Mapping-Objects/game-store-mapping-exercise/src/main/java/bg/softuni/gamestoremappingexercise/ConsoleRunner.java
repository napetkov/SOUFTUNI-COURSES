package bg.softuni.gamestoremappingexercise;

import bg.softuni.gamestoremappingexercise.services.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

import static bg.softuni.gamestoremappingexercise.constants.Commands.*;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private static final Scanner SCANNER = new Scanner(System.in);

    private final UserService userService;

    public ConsoleRunner(UserService userService) {
        this.userService = userService;
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

                default -> "No command found";
            };

            System.out.println(output);

        }



    }

    private String toDo() {
        return "";
    }
}
