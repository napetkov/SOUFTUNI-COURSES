package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P07MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> hotQueue = new ArrayDeque<>();
        String[] inputNames = scanner.nextLine().split("\\s+");
        for (String names : inputNames) {
            hotQueue.offer(names);
        }
        int n = Integer.parseInt(scanner.nextLine());

        while (hotQueue.size() > 1) {
            int counterCycle = 0;
            if (n >= hotQueue.size()) {
                for (int i = 0; i < n - 1; i++) {
                    hotQueue.offer(hotQueue.poll());
                }
                System.out.println("Prime " + hotQueue.peek());
                counterCycle++;
                if(counterCycle > (n/ hotQueue.size())){
                    break;
                }
            }

            for (int i = 0; i < n - 1; i++) {
                hotQueue.offer(hotQueue.poll());
            }
            System.out.println("Removed " + hotQueue.poll());
        }

        System.out.println("Last is " + hotQueue.poll());

    }
}
