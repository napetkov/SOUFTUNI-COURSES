package StacksAndQueues.Exercisses;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P03MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < numberOfCommands; i++) {
            String input = scanner.nextLine();
            String command = input.split(" ")[0];

            if (command.equals("1")) {
                int number = Integer.parseInt(input.split(" ")[1]);
                stack.push(number);
            } else if (command.equals("2")) {
                stack.pop();
            } else if (command.equals("3")) {
                int maxElement = Collections.max(stack);
                System.out.println(maxElement);
            }


        }


    }
}
