package FirstStepsInCoding.Exercises;

import java.util.Scanner;

public class depositCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double deposit = Double.parseDouble(scanner.nextLine());
        int term = Integer.parseInt(scanner.nextLine());
        double interestRate = Double.parseDouble(scanner.nextLine()) / 100;
        double finalSum = deposit + term * ((deposit*interestRate) / 12);
        System.out.println(finalSum);


    }
}
