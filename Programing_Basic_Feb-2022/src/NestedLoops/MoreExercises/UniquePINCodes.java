package NestedLoops.MoreExercises;

import java.util.Scanner;

public class UniquePINCodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int limitNumber1 = Integer.parseInt(scanner.nextLine());
        int limitNumber2 = Integer.parseInt(scanner.nextLine());
        int limitNumber3 = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= limitNumber1; i++) {
            boolean flagNum1 = false;
            if (i % 2 == 0) {
                flagNum1 = true;
            }
            for (int j = 2; j <= limitNumber2; j++) {
                boolean flagNum2 = false;
                if (j == 2 || j == 3 || j == 5 || j == 7) {
                    flagNum2 = true;
                }
                for (int k = 1; k <= limitNumber3; k++) {
                    boolean flagNum3 = false;
                    if (k % 2 == 0) {
                        flagNum3 = true;

                        if (flagNum1 && flagNum2 && flagNum3) {
                            System.out.printf("%d %d %d",i,j,k);
                            System.out.println();
                        }
                    }

                }
            }


        }
    }
}
