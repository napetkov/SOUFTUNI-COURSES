package BasicSyntaxConditionalStatementsAndLoops.Exercises;

import java.util.Scanner;

public class P07VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double totalMoney = 0;

        while (!input.equals("Start")) {
            double coins = Double.parseDouble(input);
            if (coins == 0.10 || coins == 0.20 || coins == 0.50 || coins == 1 || coins == 2) {
                totalMoney += coins;
            } else {
                System.out.printf("Cannot accept %.2f%n", coins);
            }
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.equals("End")) {
            double price = 0;
            String nameProduct = "";
            boolean flag = true;
            switch (input) {
                case "Nuts":
                    price = 2.0;
                    nameProduct = "Nuts";
                    break;
                case "Water":
                    price = 0.7;
                    nameProduct = "Water";
                    break;
                case "Crisps":
                    price = 1.5;
                    nameProduct = "Crisps";
                    break;
                case "Soda":
                    price = 0.8;
                    nameProduct = "Soda";
                    break;
                case "Coke":
                    price = 1.0;
                    nameProduct = "Coke";
                    break;
                default:
                    System.out.println("Invalid product");
                    flag = false;
                   break;

            }
            if(flag){

                if (totalMoney >= price) {
                    totalMoney -= price;
                    System.out.printf("Purchased %s%n", nameProduct);
                } else {
                    System.out.println("Sorry, not enough money");
                }
            }

            input = scanner.nextLine();
        }
        System.out.printf("Change: %.2f", totalMoney);

    }
}
