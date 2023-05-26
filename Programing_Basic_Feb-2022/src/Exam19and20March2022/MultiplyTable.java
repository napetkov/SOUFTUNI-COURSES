package Exam19and20March2022;

import java.util.Scanner;

public class MultiplyTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        int numberOne = number%10;
        int numberTwo = (number/10)%10;
        int numberThree =((number/10)/10)%10;
        for (int i = 1; i <=numberOne ; i++) {
            for (int j = 1; j <=numberTwo ; j++) {
                for (int k = 1; k <=numberThree ; k++) {
                    System.out.printf("%d * %d * %d = %d;%n",i,j,k,i*j*k);

                }

            }

        }
    }
}
