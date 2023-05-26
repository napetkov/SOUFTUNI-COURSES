package Arrays.MoreExercises;

import java.util.Scanner;

public class P03RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fibonacciIndex = Integer.parseInt(scanner.nextLine());
        int fibonacciCounter = 3;
        int fibonacciNumber = 1;

        if (fibonacciIndex == 1) {
            fibonacciNumber = 1;
        } else if (fibonacciIndex == 2) {
            fibonacciNumber = 1;
        }else {

            while (fibonacciCounter!=fibonacciIndex) {
                int[] fibonacciArray = new int[fibonacciIndex];
                fibonacciArray[0] = 1;
                fibonacciArray[1] = 1;
                for (int i = 2; i < fibonacciArray.length; i++) {
                    fibonacciArray[i] = fibonacciArray[i-2]+fibonacciArray[i-1];
                }
                fibonacciNumber = fibonacciArray[fibonacciArray.length-1];

                fibonacciCounter++;
            }
        }
        System.out.println(fibonacciNumber);
    }
}
