package MidExamFundamentals.FundamentalsExamsMid06;

import java.util.Arrays;
import java.util.Scanner;

public class P03ManOWar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] pirateShip = Arrays.stream(scanner.nextLine().split(">"))
                .mapToInt(Integer::parseInt).toArray();
        int[] warShip = Arrays.stream(scanner.nextLine().split(">"))
                .mapToInt(Integer::parseInt).toArray();
        int maxHealth = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        boolean isBreak = false;

        while (!input.equals("Retire")) {
            String[] commandLine = input.split(" ");
            String command = commandLine[0];

            if ("Fire".equals(command)) {
                int index = Integer.parseInt(commandLine[1]);
                int damage = Integer.parseInt(commandLine[2]);
                if (isValidAttackIndex(warShip, index)) {
                    warShip[index] -= damage;
                    if (warShip[index] <= 0) {
                        System.out.println("You won! The enemy ship has sunken.");
                        isBreak = true;
                        break;
                    }
                }
            } else if ("Defend".equals(command)) {
                int startIndex = Integer.parseInt(commandLine[1]);
                int endIndex = Integer.parseInt(commandLine[2]);
                int damage = Integer.parseInt(commandLine[3]);
                if (isValidDefendIndex(pirateShip, startIndex, endIndex)) {
                    for (int i = startIndex; i <= endIndex; i++) {
                        pirateShip[i] -= damage;
                        if (pirateShip[i] <= 0) {
                            System.out.println("You lost! The pirate ship has sunken.");
                            isBreak = true;
                            break;
                        }
                    }
                }

            } else if ("Repair".equals(command)) {
                int index = Integer.parseInt(commandLine[1]);
                int health = Integer.parseInt(commandLine[2]);
                if (isValidHealthIndex(pirateShip, index)) {
                    pirateShip[index] += health;
                    if (pirateShip[index] > maxHealth) {
                        pirateShip[index] = maxHealth;
                    }
                }
            } else if ("Status".equals(command)) {
                int counterSections = 0;
                for (int i = 0; i < pirateShip.length; i++) {
                    if (pirateShip[i] < maxHealth * 0.2) {
                        counterSections++;
                    }
                }
                System.out.printf("%d sections need repair.%n",counterSections);
            }

            input = scanner.nextLine();
        }
        int sumPirateShip = 0;
        int sumWarship = 0;

        for (int currentNumber:pirateShip) {
            sumPirateShip +=currentNumber;
        }
        for (int currentNumber:warShip) {
            sumWarship +=currentNumber;
        }
        if(!isBreak){
            System.out.printf("Pirate ship status: %d%n",sumPirateShip);
            System.out.printf("Warship status: %d%n",sumWarship);
        }
    }

    private static boolean isValidHealthIndex(int[] pirateShip, int index) {
        return index >= 0 && index < pirateShip.length;
    }

    private static boolean isValidDefendIndex(int[] pirateShip, int startIndex, int endIndex) {
        return startIndex >= 0 && startIndex < pirateShip.length && endIndex >= 0 && endIndex < pirateShip.length;
    }

    private static boolean isValidAttackIndex(int[] warShip, int index) {
        return index >= 0 && index < warShip.length;
    }
}
