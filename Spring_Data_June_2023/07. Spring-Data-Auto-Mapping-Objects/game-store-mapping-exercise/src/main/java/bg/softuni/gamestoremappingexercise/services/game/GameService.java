package bg.softuni.gamestoremappingexercise.services.game;

public interface GameService {
    String addGame(String[] args);
    String deleteGame(String[] args);
    String editGame(String[] args);

    String printAllGames();

    String printGameDetails(String[] arguments);
}
