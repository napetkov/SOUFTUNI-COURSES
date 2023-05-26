package StacksAndQueues.Exercisses;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P04BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int countToAdd = Integer.parseInt(input[0]);
        int countToRemove = Integer.parseInt(input[1]);
        int numberToChek = Integer.parseInt(input[2]);

        String[] numbers = scanner.nextLine().split(" ");
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < countToAdd; i++) {
            queue.offer(Integer.parseInt(numbers[i]));
        }
        for (int i = 0; i < countToRemove; i++) {
            queue.poll();
        }

        if(queue.isEmpty()){
            System.out.println("0");
        }else if(queue.contains(numberToChek)){
            System.out.println("true");
        }else{
            int minElement = Collections.min(queue);
            System.out.println(minElement);
        }


    }
}
