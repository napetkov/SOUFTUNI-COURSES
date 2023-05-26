package Methods.Lab;

import java.util.Scanner;

public class P03PrintingTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputNum = Integer.parseInt(scanner.nextLine());
        printTriangles(inputNum);

    }
    public static void printTriangles(int num){
        for (int i = 1; i <= num; i++) {
            printLine(1,i);
        }
        for (int i = num-1; i >0 ; i--) {
            printLine(1,i);
        }
    }
    public static void printLine(int start, int end){
        for (int i = start; i <=end ; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }


}
