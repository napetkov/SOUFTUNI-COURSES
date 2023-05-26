package ExamsPractis.Exam9and10March2019;

import java.util.Scanner;

public class BasketballTournament {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int countWins = 0;
        int countLoses = 0;
        int countGames = 0;
        while (!input.equals("End of tournaments")) {
            int numberOfGames = Integer.parseInt(scanner.nextLine());
            for (int i = 1; i <= numberOfGames; i++) {
                countGames++;
                int desiPoints = Integer.parseInt(scanner.nextLine());
                int opponentsPoints = Integer.parseInt(scanner.nextLine());
                if (desiPoints > opponentsPoints) {
                    countWins++;
                    System.out.printf("Game %d of tournament %s: win with %d points.%n", i, input, desiPoints - opponentsPoints);
                } else if (opponentsPoints > desiPoints) {
                    countLoses++;
                    System.out.printf("Game %d of tournament %s: lost with %d points.%n", i, input, opponentsPoints - desiPoints);
                }
            }
            input = scanner.nextLine();
        }
        System.out.printf("%.2f%% matches win%n", countWins*1.00 / countGames * 100.00);
        System.out.printf("%.2f%% matches lost", countLoses*1.00 / countGames * 100.00);


    }

}
