package MidExamFundamentals.FundamentalsExamsMid02;

import java.util.Scanner;

public class P01SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int employer1 = Integer.parseInt(scanner.nextLine());
        int employer2 = Integer.parseInt(scanner.nextLine());
        int employer3 = Integer.parseInt(scanner.nextLine());

        int studentCount = Integer.parseInt(scanner.nextLine());

        int sumOfStudentsForHour = employer1 + employer2 + employer3;
        int neededHour = 0;

        while (studentCount > 0) {
            neededHour++;

            if (neededHour % 4 != 0) {
                studentCount -= sumOfStudentsForHour;
            }
        }
        System.out.printf("Time needed: %dh.",neededHour);

    }
}
