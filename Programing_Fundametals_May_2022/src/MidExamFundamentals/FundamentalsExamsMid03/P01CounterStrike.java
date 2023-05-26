package MidExamFundamentals.FundamentalsExamsMid03;

import java.util.Scanner;

public class P01CounterStrike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int energy = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();
        int countWonBattle = 0;
        boolean isDead = false;

        while (!input.equals("End of battle")) {
            int distance = Integer.parseInt(input);


            if ((energy - distance) < 0) {
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", countWonBattle, energy);
                isDead = true;
                break;
            } else {
                energy -= distance;
                countWonBattle++;
                if (countWonBattle % 3 == 0) {
                    energy += countWonBattle;
                }
            }
            input = scanner.nextLine();
        }
        if (!isDead) {
            System.out.printf("Won battles: %d. Energy left: %d", countWonBattle, energy);
        }
    }
}
