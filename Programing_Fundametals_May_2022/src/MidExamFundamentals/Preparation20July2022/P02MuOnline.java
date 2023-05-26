package MidExamFundamentals.Preparation20July2022;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initialHealth = 100;
        int bitcoins = 0;
        boolean isAlive = true;
        List<String> rooms = Arrays.stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toList());
        for (int i = 0; i < rooms.size(); i++) {
            List<String> commandLine = Arrays.stream(rooms.get(i).split(" "))
                    .collect(Collectors.toList());

            //след сплитване взимамекомандата от 1вистринг
            String command = commandLine.get(0);
            if ("potion".equals(command)) {
                int healthNumber = Integer.parseInt(commandLine.get(1));
                initialHealth += healthNumber;//80+54
                //проверка за приравняване на 100
                if (initialHealth > 100) { //134
                    int numberOverHundred = initialHealth - 100;//34
                    System.out.printf("You healed for %d hp.%n", healthNumber - numberOverHundred);
                    initialHealth = 100;
                    System.out.printf("Current health: %d hp.%n", initialHealth);
                } else {
                    System.out.printf("You healed for %d hp.%n", healthNumber);
                    System.out.printf("Current health: %d hp.%n", initialHealth);
                }
            } else if ("chest".equals(command)) {
                int foundBitcoins = Integer.parseInt(commandLine.get(1));
                System.out.printf("You found %d bitcoins.%n", foundBitcoins);
                bitcoins += foundBitcoins;
            } else {
                int monsterAttack = Integer.parseInt(commandLine.get(1));
                initialHealth -= monsterAttack;
                if (initialHealth > 0) {
                    System.out.printf("You slayed %s.%n", command);
                } else {
                    System.out.printf("You died! Killed by %s.%n", command);
                    System.out.printf("Best room: %d%n", i + 1);
                    isAlive = false;
                    break;
                }
            }
        }
        if (isAlive) {
            System.out.println("You've made it!");
            System.out.printf("Bitcoins: %d%n", bitcoins);
            System.out.printf("Health: %d", initialHealth);
        }
    }
}
