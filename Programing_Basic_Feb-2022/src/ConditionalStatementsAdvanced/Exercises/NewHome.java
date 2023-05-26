package ConditionalStatementsAdvanced.Exercises;

import java.util.Scanner;

public class NewHome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String flowers = scanner.nextLine();
        int amount = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());
        double price = 0;
        double allprice = 0;

        switch (flowers) {
            case "Roses":
                price = 5;
                allprice = price * amount;
                if (amount > 80) {
                    allprice = allprice * 0.9;
                }
                break;
            case "Dahlias":
                price = 3.8;
                allprice = price * amount;
                if (amount > 90) {
                    allprice = allprice * 0.85;
                }
                break;
            case "Tulips":
                price = 2.8;
                allprice = price * amount;
                if (amount > 80) {
                    allprice = allprice * 0.85;
                }
                break;
            case "Narcissus":
                price = 3.00;
                allprice = price * amount;
                if (amount < 120) {
                    allprice = allprice * 1.15;
                }
                break;
            case "Gladiolus":
                price = 2.50;
                allprice = price * amount;
                if (amount < 80) {
                    allprice = allprice * 1.20;
                    break;

                }
        }
        if (budget >= allprice){
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", amount, flowers, budget - allprice);
        }else{
            System.out.printf("Not enough money, you need %.2f leva more.", allprice - budget);
        }

    }
}
