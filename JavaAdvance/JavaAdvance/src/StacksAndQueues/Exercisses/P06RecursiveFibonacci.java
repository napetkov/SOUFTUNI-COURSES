package StacksAndQueues.Exercisses;

import java.sql.Array;
import java.util.Scanner;

public class P06RecursiveFibonacci {
    public static long[] memory;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        memory = new long[n+1];

        System.out.println(fibonachi(n));


    }

    private static long fibonachi(int n) {
        if(n<2){
            return 1;
        }
        if(memory[n]!=0){
            return memory[n];
        }
        memory[n] = fibonachi(n-1)+fibonachi(n-2);
        return memory[n];
    }
}
