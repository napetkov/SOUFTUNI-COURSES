package StacksAndQueues.Exercisses;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P01ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split(" ");
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (String number : numbers) {
            stack.push(number);
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }



    }
}
