package WhileLoop.MoreExercises;

import java.util.Scanner;

public class ReportSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int moneyForCharity = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();
        int count = 0;
        int amount = 0;
        double sumCash = 0;
        double sumCard = 0;
        double totalMoney = 0;
        int countCash = 0;
        int countCard = 0;
        boolean isEnough = false;
        while (!input.equals("End")) {
            count++;
            amount = Integer.parseInt(input);

            if (count % 2 != 0 && amount <= 100) {//Плащания е брой
                countCash++;
                sumCash += amount;
                System.out.println("Product sold!");
            } else if (count % 2 == 0 && amount >= 10) {//плащания с карта
                countCard++;
                sumCard += amount;
                System.out.println("Product sold!");
            } else {
                System.out.println("Error in transaction!");
            }
            totalMoney = sumCash + sumCard;
            if (totalMoney >= moneyForCharity) {
                isEnough = true;
                break;
            }
            input = scanner.nextLine();
        }
        if (isEnough) {
            System.out.printf("Average CS: %.2f%n", sumCash / countCash);
            System.out.printf("Average CC: %.2f%n", sumCard / countCard);
        } else {
            System.out.println("Failed to collect required money for charity.");
        }
    }

}
