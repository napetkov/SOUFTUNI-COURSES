package Exam19and20March2022;

import java.util.Scanner;

public class CatDiet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int percentFat = Integer.parseInt(scanner.nextLine());
        int percentProteins = Integer.parseInt(scanner.nextLine());
        int percentCarbohydrates = Integer.parseInt(scanner.nextLine());
        int totalCalories = Integer.parseInt(scanner.nextLine());
        int percentWater = Integer.parseInt(scanner.nextLine());
        double fats = totalCalories * (percentFat / 100.00) / 9;
        double proteins = totalCalories * (percentProteins / 100.00) / 4;
        double carbohydrates = totalCalories * (percentCarbohydrates / 100.00) / 4;
        double weightFood = fats + proteins + carbohydrates;
        double caloriesForGram = totalCalories / weightFood;
       caloriesForGram = caloriesForGram*(1-(percentWater/100.00));
        System.out.printf("%.4f",caloriesForGram);

    }
}
