package ConditionalStatementsAdvanced.Lab;

import java.util.Scanner;

public class FruitShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fruit = scanner.nextLine();
        String day = scanner.nextLine();
        double amount = Double.parseDouble(scanner.nextLine());

        double price = 0;
        if ("Monday".equals(day) || "Tuesday".equals(day) || "Wednesday".equals(day) || "Thursday".equals(day) || "Friday".equals(day)) {
            switch (fruit) {
                case "banana":
                    price = 2.50;
                    System.out.printf("%.2f",price * amount);
                    break;
                case "apple":
                    price = 1.20;
                    System.out.printf("%.2f",price * amount);
                    break;
                case "orange":
                    price = 0.85;
                    System.out.printf("%.2f",price * amount);

                    break;
                case "grapefruit":
                    price = 1.45;
                    System.out.printf("%.2f",price * amount);
                    break;
                case "kiwi":
                    price = 2.70;
                    System.out.printf("%.2f",price * amount);
                    break;
                case "pineapple":
                    price = 5.50;
                    System.out.printf("%.2f",price * amount);
                    break;
                case "grapes":
                    price = 3.85;
                    System.out.printf("%.2f",price * amount);
                    break;
                default:
                    System.out.println("error");
                    break;
            }
        } else if ("Saturday".equals(day) || "Sunday".equals(day)) {
            switch (fruit) {
                case "banana":
                    price = 2.70;
                    System.out.printf("%.2f",price * amount);
                    break;
                case "apple":
                    price = 1.25;
                    System.out.printf("%.2f",price * amount);
                    break;
                case "orange":
                    price = 0.90;
                    System.out.printf("%.2f",price * amount);
                    break;
                case "grapefruit":
                    price = 1.60;
                    System.out.printf("%.2f",price * amount);
                    break;
                case "kiwi":
                    price = 3.00;
                    System.out.printf("%.2f",price * amount);
                    break;
                case "pineapple":
                    price = 5.60;
                    System.out.printf("%.2f",price * amount);
                    break;
                case "grapes":
                    price = 4.20;
                    System.out.printf("%.2f",price * amount);
                    break;
                default:
                    System.out.println("error");
                    break;
            }
        } else {
            System.out.println("error");
        }

    }
}
