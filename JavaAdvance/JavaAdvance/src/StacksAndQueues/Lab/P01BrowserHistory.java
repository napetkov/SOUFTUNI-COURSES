package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P01BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        ArrayDeque<String> stack = new ArrayDeque<>();

        while(!input.equals("Home")){
            boolean isLastURL = false;
            if(input.equals("back")){
                if(stack.size()<=1){
                    System.out.println("no previous URLs");
                    isLastURL = true;
                }else{
                    stack.pop();
                }
            }else{
                stack.push(input);
            }
            if(!isLastURL) {
                System.out.println(stack.peek());
            }

            input = scanner.nextLine();
        }
    }
}
