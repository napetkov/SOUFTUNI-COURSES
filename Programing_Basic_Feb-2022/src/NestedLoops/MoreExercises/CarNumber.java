package NestedLoops.MoreExercises;

import java.util.Scanner;

public class CarNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());
        for (int i = start; i <= end; i++) {
            for (int j = start; j <= end; j++) {
                for (int k = start; k <= end; k++) {
                    for (int l = start; l <= end; l++) {
                        boolean firstNumberEven = false;
                        boolean firstNumberOdd = false;
                        boolean isBigger = false;
                        boolean sumNumber = false;
                        if (i % 2 == 0 && l % 2 != 0) {
                            firstNumberEven = true;
                        } else if (i % 2 != 0 && l % 2 == 0) {
                            firstNumberOdd = true;
                        }
                        if (i > l) {
                            isBigger = true;
                        }
                        if ((j + k) % 2 == 0) {
                            sumNumber = true;
                        }
                        if((firstNumberEven||firstNumberOdd)&&isBigger&&sumNumber){
                            System.out.printf("%d%d%d%d ",i,j,k,l);
                        }
                    }

                }

            }

        }

    }
}
