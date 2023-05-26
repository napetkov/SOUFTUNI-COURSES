package ConditionalStatements.Exercises;

import java.util.Scanner;

public class GodzillaVsKong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int people = Integer.parseInt(scanner.nextLine());
        double dressesForOne = Double.parseDouble(scanner.nextLine());
        double allDressesPrice = dressesForOne * people;

        double decor = budget * 0.1;
        if (people >150){
            allDressesPrice = allDressesPrice - allDressesPrice*0.10;

        }
        double neededBudget = allDressesPrice + decor;
        double difference = Math.abs(budget - neededBudget);

        if (neededBudget > budget){
            System.out.println("Not enough money!");
            System.out.printf("Wingard needs %.2f leva more.",difference);
        }else{
            System.out.println("Action!");
            System.out.printf("Wingard starts filming with %.2f leva left.",difference);
        }
    }
}
