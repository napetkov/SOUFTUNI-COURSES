package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P02SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
          ArrayDeque<String> queue = new ArrayDeque<>();

        for (String element : input) {
            queue.offer(element);
        }

        while (queue.size() > 1) {
            int first = Integer.parseInt(queue.poll());
            String command = queue.poll();
            int second = Integer.parseInt(queue.poll());

            switch (command) {

                case "+":
                    queue.offerFirst(String.valueOf(first+second));
                    break;
                case "-":
                    queue.offerFirst(String.valueOf(first-second));
                    break;
            }
        }
        System.out.println(queue.poll());


    }
}
