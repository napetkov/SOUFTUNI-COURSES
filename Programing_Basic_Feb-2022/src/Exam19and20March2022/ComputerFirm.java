package Exam19and20March2022;

import java.util.Scanner;

public class ComputerFirm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbersOfComputers = Integer.parseInt(scanner.nextLine());
        double sales = 0;
        double sumRating = 0;
        for (int i = 1; i <= numbersOfComputers; i++) {
            int possibleSales = Integer.parseInt(scanner.nextLine());
            int rating = possibleSales % 10;
            sumRating +=rating;
            possibleSales = possibleSales / 10;
            if (rating == 2) {
                sales += 0;
            } else if (rating == 3) {
                sales += 0.50*possibleSales;
            }else if(rating==4){
                sales += 0.70*possibleSales;
            }else if(rating==5){
                sales += 0.85*possibleSales;
            }else if(rating==6){
                sales += possibleSales;
            }

        }
        System.out.printf("%.2f%n",sales);
        System.out.printf("%.2f",sumRating/numbersOfComputers);


    }
}
