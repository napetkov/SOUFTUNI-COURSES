package NestedLoops.Exercises;

import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1111; i < 10000; i++) {
            //2418
            int count =0;
            int number = i;
            boolean flag = false;
            for (int j = 4; j >= 1; j--) {
                int digit = number % 10;
                if(digit==0){
                    continue;
                }else if (n % digit == 0) {
                    count++;
                }
                number = number/10;
            }
            if (count==4){
                System.out.printf("%d ",i);
            }
        }
    }
}
