package WhileLoop.Exercises;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double neededMoney = Double.parseDouble(scanner.nextLine());
        double savedMoney = Double.parseDouble(scanner.nextLine());
        double totalMoney = 0;
        int days = 0;
        int spendDays = 0;

        while (savedMoney < neededMoney && spendDays < 5) {
            String command = scanner.nextLine();
            double receivedMoney = Double.parseDouble(scanner.nextLine());
            days++;
            if ("spend".equals(command)) {
                spendDays++;
                savedMoney -= receivedMoney;
                if (savedMoney < 0) {
                    savedMoney = 0;
                }
            } else if ("save".equals(command)) {
                savedMoney += receivedMoney;
                spendDays = 0;

            }

        }
        if (spendDays == 5) {
            System.out.printf("You can't save the money.%n%d%n", days);
        }
        if (savedMoney >= neededMoney) {
            System.out.printf("You saved the money for %d days.", days);
        }

    }
}
