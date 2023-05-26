package ExamPerparation;

import java.util.Scanner;

public class VetParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        int hoers = Integer.parseInt(scanner.nextLine());
        double totalTax = 0;
        for (int i = 1; i <= days; i++) {
            double tax = 0;
            double sumTax = 0;
            for (int j = 1; j <= hoers; j++) {
                if (i % 2 == 0 && j % 2 != 0) {
                    tax = 2.5;
                } else if (i % 2 != 0 && j % 2 == 0) {
                    tax = 1.25;
                } else {
                    tax = 1;
                }
                sumTax += tax;
            }
            System.out.printf("Day: %d - %.2f leva%n",i,sumTax);
            totalTax += sumTax;
        }
        System.out.printf("Total: %.2f leva",totalTax);


    }
}
