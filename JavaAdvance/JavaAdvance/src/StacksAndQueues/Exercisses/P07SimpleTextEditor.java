package StacksAndQueues.Exercisses;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P07SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder text = new StringBuilder();
        ArrayDeque<String> stack = new ArrayDeque<>();


        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            int command = Integer.parseInt(input.split("\\s")[0]);
            if (command == 1) {
                text.append(input.split("\\s")[1]);
                stack.push(text.toString());
            } else if (command == 2) {
                int startIndex = text.length() - Integer.parseInt(input.split(" ")[1]);
                if (startIndex < 0) {
                    startIndex = 0;
                }
                text.delete(startIndex, text.length());
                stack.push(text.toString());
            } else if (command == 3) {
                int index = Integer.parseInt(input.split(" ")[1]) - 1;
                if(index<0){
                    index=0;
                }
                if(text.length()<=0){
                    System.out.println();
                }else {
                System.out.println(text.charAt(index));
                }
            } else if (command == 4) {
                if(!stack.isEmpty()) {
                    stack.pop();
                    text = new StringBuilder(stack.peek());
                }
            }
        }

    }
}
