package WhileLoop.Exercises;

import java.util.Scanner;

public class Coins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double change = Double.parseDouble(scanner.nextLine());
        int counterCoins = 0;
        double coins = change * 100;
        while (coins != 0) {
            if (coins >= 200) {
                coins -= 200;
                counterCoins++;
            } else if (coins >= 100) {
                coins -= 100;
                counterCoins++;
            } else if (coins >= 50) {
                coins -= 50;
                counterCoins++;
            } else if (coins >= 20) {
                coins -= 20;
                counterCoins++;
            } else if (coins >= 10) {
                coins -= 10;
                counterCoins++;
            } else if (coins >= 5) {
                coins -= 5;
                counterCoins++;
            } else if (coins >= 2) {
                coins -= 2;
                counterCoins++;
            } else if (coins >= 1) {
                coins -= 1;
                counterCoins++;
            } else {
                break;
            }

        }
        System.out.println(counterCoins);

    }
}
