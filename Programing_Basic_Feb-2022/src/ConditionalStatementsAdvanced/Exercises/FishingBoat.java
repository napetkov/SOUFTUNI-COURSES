package ConditionalStatementsAdvanced.Exercises;

import java.util.Scanner;

public class FishingBoat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int budget = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        int fishermans = Integer.parseInt(scanner.nextLine());
        double price = 0;
        double discountFisherman = 0;
        double allPrice = 0;
        //четен брой без есен
        switch (season) {
            case "Spring":
                price = 3000;
                break;
            case "Summer":
                price = 4200;
                break;
            case "Autumn":
                price = 4200;
                break;
            case "Winter":
                price = 2600;
                break;
        }
        if (fishermans <= 6) {
            discountFisherman = price * 0.10;
        } else if (fishermans <= 11) {
            discountFisherman = price * 0.15;
        } else {
            discountFisherman = price * 0.25;
        }
        allPrice = price - discountFisherman;
        if (fishermans % 2 == 0 && !season.equals("Autumn")) {
            allPrice = allPrice * 0.95;
        }
        if(budget>=allPrice){
            System.out.printf("Yes! You have %.2f leva left.",budget-allPrice);
        }else{
            System.out.printf("Not enough money! You need %.2f leva.",allPrice-budget);
        }

    }
}
