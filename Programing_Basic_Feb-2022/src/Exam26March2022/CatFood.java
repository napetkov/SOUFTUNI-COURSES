package Exam26March2022;

import java.util.Scanner;

public class CatFood {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cats = Integer.parseInt(scanner.nextLine());
        int group1 = 0;
        int group2 = 0;
        int group3 = 0;
        double totalFood = 0;

        for (int i = 0; i < cats; i++) {
            double foodGrams = Double.parseDouble(scanner.nextLine());
            if (foodGrams >= 100 && foodGrams < 200) {
                group1++;
            } else if (foodGrams >= 200 && foodGrams < 300) {
                group2++;
            } else if (foodGrams >= 300 && foodGrams < 400) {
                group3++;
            }
            totalFood+=foodGrams;
        }
        System.out.printf("Group 1: %d cats.%n",group1);
        System.out.printf("Group 2: %d cats.%n",group2);
        System.out.printf("Group 3: %d cats.%n",group3);
        System.out.printf("Price for food per day: %.2f lv.",totalFood/1000*12.45);

    }
}
