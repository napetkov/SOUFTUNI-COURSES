package DrawingFigures;

import java.util.Scanner;

public class Diamond {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int leftRight = (n - 1) / 2;
        int middle = 0;

        for (int i = 0; i < (n + 1) / 2; i++) {
            middle = n - 2 * leftRight - 2;
            for (int j = leftRight; 0 < j; j--) {
                System.out.print("-");
            }
            System.out.print("*");
            for (int j = 0; j < middle; j++) {
                System.out.print("-");
            }
            if (middle >= 0) {
                System.out.print("*");
            }
            for (int j = leftRight; 0 < j; j--) {
                System.out.print("-");
            }
            leftRight--;
            System.out.println();
        }
        leftRight = 1;
        for (int i = 0; i < ((n + 1) / 2) - 1; i++) {
            middle = n - 2 * leftRight - 2;
            for (int j = 0; j < leftRight; j++) {
                System.out.print("-");
            }
            System.out.print("*");
            for (int j = 0; j < middle; j++) {
                System.out.print("-");
            }
            if(middle>=0){
                System.out.print("*");
            }
            for (int j = 0; j < leftRight; j++) {
                System.out.print("-");
            }

            leftRight++;
            System.out.println();
        }


    }

}


