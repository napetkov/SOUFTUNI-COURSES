package NestedLoops.MoreExercises;

import java.util.Scanner;

public class WeddingSeats {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String lastSector = scanner.nextLine();
        int rowsFirstSector = Integer.parseInt(scanner.nextLine());
        int seatsOddRow = Integer.parseInt(scanner.nextLine());
        int numberSeats = 0;
        int counter = 0;
        for (int i = 'A'; i <= lastSector.charAt(0); i++) {
            for (int j = 1; j <= rowsFirstSector; j++) {
                if (j % 2 != 0) {
                    numberSeats = seatsOddRow;
                } else {
                    numberSeats = (seatsOddRow + 2);
                }
                for (int k = 'a'; k < 'a' + numberSeats; k++) {

                    System.out.printf("%c%d%c%n", i, j, k);
                    counter++;
                }
            }
            rowsFirstSector++;

        }
        System.out.println(counter);

    }
}
