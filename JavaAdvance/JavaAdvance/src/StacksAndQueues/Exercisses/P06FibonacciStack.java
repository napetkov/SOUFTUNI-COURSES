package StacksAndQueues.Exercisses;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P06FibonacciStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Long> fibonacci = new ArrayDeque<>();

        fibonacci.push(0l);
        fibonacci.push(1l);

        for (int i = 0; i < n; i++) {
          long num1 = fibonacci.pop();
          long num2 = fibonacci.pop();
            fibonacci.push(num1);
            fibonacci.push(num1+num2);
        }

        System.out.println(fibonacci.pop());

    }
}
