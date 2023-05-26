package Methods.Exercises;

import java.util.Scanner;

public class P07NxNMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
       printMatrix(number);

    }

    public static void printLine(int number){
        for (int i = 0; i < number; i++) {
            System.out.print(number+" ");
        }
    }
    public static void printMatrix(int number){
        for (int i = 0; i < number; i++) {
            printLine(number);
            System.out.println();
        }


    }

}
