package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P08BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        ArrayDeque<String> stackBack = new ArrayDeque<>();
        ArrayDeque<String> stackForward = new ArrayDeque<>();

        while (!input.equals("Home")) {

            if (input.equals("back")) {
                if (stackBack.size() <= 1) {
                    System.out.println("no previous URLs");
                } else {
                    stackForward.push(stackBack.pop());
                    System.out.println(stackBack.peek());
                }
            } else if(input.equals("forward")){
                if(stackForward.isEmpty()){
                    System.out.println("no next URLs");
                }else{
                    stackBack.push(stackForward.peek());
                    System.out.println(stackForward.pop());
                }
            }else{
                stackBack.push(input);
                System.out.println(stackBack.peek());
                stackForward.clear();
            }

            input = scanner.nextLine();
        }
    }
}

