package BasicSyntaxConditionalStatementsAndLoops.Exercises;

import java.util.Scanner;

public class P03Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberPeople = Integer.parseInt(scanner.nextLine());
        String groupOfPeople = scanner.nextLine();
        String day = scanner.nextLine();
        double priceForPerson = 0;
        double totalPrice = 0;
        switch (groupOfPeople) {
            case "Students":
                switch (day) {
                    case "Friday":
                        priceForPerson = 8.45;
                        break;
                    case "Saturday":
                        priceForPerson = 9.80;
                        break;
                    case "Sunday":
                        priceForPerson = 10.46;
                        break;
                }
                totalPrice = priceForPerson * numberPeople;
                if (numberPeople >= 30) {
                    totalPrice = totalPrice * 0.85;
                }
                break;
            case "Business":
                switch (day) {
                    case "Friday":
                        priceForPerson = 10.90;
                        break;
                    case "Saturday":
                        priceForPerson = 15.60;
                        break;
                    case "Sunday":
                        priceForPerson = 16;
                        break;
                }
                totalPrice = priceForPerson * numberPeople;
                if (numberPeople >= 100) {
                    totalPrice = totalPrice - priceForPerson * 10;
                }
                break;
            case "Regular":
                switch (day) {
                    case "Friday":
                        priceForPerson = 15;
                        break;
                    case "Saturday":
                        priceForPerson = 20;
                        break;
                    case "Sunday":
                        priceForPerson = 22.50;
                        break;
                }
                totalPrice = priceForPerson * numberPeople;
                if (numberPeople >= 10 && numberPeople <= 20) {
                    totalPrice = totalPrice * 0.95;
                }
                break;

        }
        System.out.printf("Total price: %.2f",totalPrice);

    }


}
