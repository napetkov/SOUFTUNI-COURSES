package ExamPerparation;

import java.util.Scanner;

public class FamilyTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int nights =Integer.parseInt(scanner.nextLine());
        double priceForNight = Double.parseDouble(scanner.nextLine());
        int percentCosts = Integer.parseInt(scanner.nextLine());
        if(nights>7){
            priceForNight = priceForNight*0.95;
        }
        double neededBudget = nights*priceForNight;
        neededBudget = neededBudget+budget*(percentCosts/100.00);

        if(neededBudget<=budget){
            System.out.printf("Ivanovi will be left with %.2f leva after vacation.",budget-neededBudget);
        }else{
            System.out.printf("%.2f leva needed.",neededBudget-budget);
        }


    }
}
