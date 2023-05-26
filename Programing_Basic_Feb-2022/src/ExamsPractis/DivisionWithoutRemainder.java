package ExamsPractis;

import java.util.Scanner;

public class DivisionWithoutRemainder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int counterP1 = 0;
        int counterP2 = 0;
        int counterP3 = 0;
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            if (number % 2 == 0) {
                counterP1++;
            }
            if (number % 3 == 0) {
                counterP2++;
            }
            if (number % 4 == 0) {
                counterP3++;
            }
        }
        System.out.printf("%.2f%%%n", counterP1 * 1.00 / n * 100.00);
        System.out.printf("%.2f%%%n", counterP2 * 1.00 / n * 100.00);
        System.out.printf("%.2f%%", counterP3 * 1.00 / n * 100.00);


    }
}
