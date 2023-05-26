package BasicSyntaxConditionalStatementsAndLoops.MoreExercises;

import java.util.Scanner;

public class P03GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double moneyBalance = Double.parseDouble(scanner.nextLine());
        String input = scanner.nextLine();
        double price = 0;
        double leftMoney = moneyBalance;
        boolean flagOutOfMoney = true;
        while (!input.equals("Game Time")) {
            boolean flag = true;
            switch (input) {
                case "OutFall 4":
                    price = 39.99;
                    break;
                case "CS: OG":
                    price = 15.99;
                    break;
                case "Zplinter Zell":
                    price = 19.99;
                    break;
                case "Honored 2":
                    price = 59.99;
                    break;
                case "RoverWatch":
                    price = 29.99;
                    break;
                case "RoverWatch Origins Edition":
                    price = 39.99;
                    break;
                default:
                    flag = false;
                    System.out.println("Not Found");
                    break;

            }
            if (leftMoney < price) {
                System.out.println("Too Expensive");
                flag = false;
            }
            if (flag) {
                System.out.printf("Bought %s%n", input);
                leftMoney -= price;
            }

            if (leftMoney == 0) {
                System.out.println("Out of money!");
                flagOutOfMoney = false;
                break;
            }
            input = scanner.nextLine();
        }
        if (flagOutOfMoney) {

            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", moneyBalance - leftMoney, leftMoney);
        }
    }
}
