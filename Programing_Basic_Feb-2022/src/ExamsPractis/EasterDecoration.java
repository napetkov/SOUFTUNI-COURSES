package ExamsPractis;

import java.util.Scanner;

public class EasterDecoration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int clients = Integer.parseInt(scanner.nextLine());
        double totalSum = 0;

        for (int i = 0; i < clients; i++) {
            double sumItems = 0;
            String input = scanner.nextLine();
            int counter = 0;

            while (!input.equals("Finish")) {
                counter++;
                switch (input) {
                    case "basket":
                        sumItems += 1.50;
                        break;
                    case "wreath":
                        sumItems += 3.80;
                        break;
                    case "chocolate bunny":
                        sumItems += 7.00;
                        break;
                }
                input = scanner.nextLine();
            }
            if (counter % 2 == 0) {
                sumItems = sumItems * 0.80;
            }
            System.out.printf("You purchased %d items for %.2f leva.%n", counter, sumItems);
            totalSum += sumItems;
        }
        System.out.printf("Average bill per client is: %.2f leva.", totalSum / clients);


    }
}
