package NestedLoops.MoreExercises;

import java.util.Scanner;

public class SafePasswordsGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int maxPassword = Integer.parseInt(scanner.nextLine());
        int countPass = 0;
        int i = 35;
        int j = 64;

        for (int k = 1; k <= a; k++) {
            for (int l = 1; l <= b; l++) {
                countPass++;
                if (countPass > maxPassword) {
                    break;
                }
                System.out.printf("%c%c%d%d%c%c|", i, j, k, l, j, i);
                if (i == 55) {
                    i = 34;
                }
                if (j == 96) {
                    j = 63;
                }
                i++;
                j++;
            }

        }

    }

}

