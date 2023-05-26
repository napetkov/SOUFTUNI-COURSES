package NestedLoops.MoreExercises;

import java.util.Scanner;

public class TheSongOfTheWheels {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = Integer.parseInt(scanner.nextLine());
        int counter = 0;
        int password = 0;
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    for (int l = 1; l <= 9; l++) {
                        if (i < j && k > l && (i * j + k * l) == m) {
                            counter++;
                                System.out.printf("%d%d%d%d ", i, j, k, l);
                               if(counter==4){
                                   password = i*1000+j*100+k*10+l;
                               }
                        }

                    }

                }

            }

        }
        System.out.println();
        if(counter>=4) {
            System.out.printf("Password: %d", password);
        }else{
            System.out.println("No!");
        }

    }
}
