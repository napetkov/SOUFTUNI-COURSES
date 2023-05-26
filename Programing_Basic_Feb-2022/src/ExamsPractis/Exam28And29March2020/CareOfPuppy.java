package ExamsPractis.Exam28And29March2020;

import java.util.Scanner;

public class CareOfPuppy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int boughtFood = Integer.parseInt(scanner.nextLine())*1000;
        String input = scanner.nextLine();
        int sumFood = 0;
        while (!input.equals("Adopted")) {
            int food = Integer.parseInt(input);
            sumFood += food;

            input = scanner.nextLine();
        }
        if (boughtFood >= sumFood) {
            System.out.printf("Food is enough! Leftovers: %d grams.", boughtFood - sumFood);
        } else {
            System.out.printf("Food is not enough. You need %d grams more.", sumFood - boughtFood);
        }
    }
}
