package DrawingFigures;

import java.util.Scanner;

public class Sunglasses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n * 2; i++) {
            System.out.print("*");
        }
        for (int i = 0; i < n; i++) {
            System.out.print(" ");
        }
        for (int i = 0; i < n * 2; i++) {
            System.out.print("*");
        }
        System.out.println();
        for (int i = 0; i < n - 2; i++) {
            System.out.print("*");
            for (int j = 0; j < (n * 2)-2; j++) {
                System.out.print("/");
            }
            System.out.print("*");


            for (int j = 0; j < n; j++) {
               if(i==(n-1)/2-1){
                   System.out.print("|");
               }else{
                   System.out.print(" ");
               }
            }
            System.out.print("*");
            for (int j = 0; j < (n * 2)-2; j++) {
                System.out.print("/");
            }
            System.out.print("*");

            System.out.println();
        }
        for (int i = 0; i < n * 2; i++) {
            System.out.print("*");
        }
        for (int i = 0; i < n; i++) {
            System.out.print(" ");
        }
        for (int i = 0; i < n * 2; i++) {
            System.out.print("*");
        }


    }
}
