package NestedLoops.Exercises;

import java.util.Scanner;

public class TrainTheTrainers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int jory = Integer.parseInt(scanner.nextLine());
        double sumAssessment = 0;
        double totalAssessment = 0;
        int count = 0;
        String namePresentation = scanner.nextLine();
        while (!namePresentation.equals("Finish")) {
            count++;
            for (int i = 0; i < jory; i++) {
                double assessment = Double.parseDouble(scanner.nextLine());
                sumAssessment += assessment;
            }
            totalAssessment += sumAssessment/jory;

            System.out.printf("%s - %.2f.%n", namePresentation, sumAssessment / jory);
            sumAssessment = 0;
            namePresentation = scanner.nextLine();
        }
        System.out.printf("Student's final assessment is %.2f.",totalAssessment/count);

    }
}
