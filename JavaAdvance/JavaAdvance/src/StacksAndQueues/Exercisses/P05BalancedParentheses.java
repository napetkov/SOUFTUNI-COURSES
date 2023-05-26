package StacksAndQueues.Exercisses;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P05BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        ArrayDeque<Character> brackets = new ArrayDeque<>();
        boolean balanced = true;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(' || input.charAt(i) == '{' || input.charAt(i) == '[') {
                brackets.push(input.charAt(i));
            }else if(brackets.isEmpty()){
                balanced = false;
                break;
            }else if (input.charAt(i) == ')' && brackets.pop() != '(') {
                balanced = false;
                break;
            }else if(input.charAt(i) == '}' && brackets.pop() != '{'){
                balanced = false;
                break;
            }else if(input.charAt(i) == ']' && brackets.pop() != '['){
                balanced = false;
                break;
            }
        }

        if(balanced&&brackets.isEmpty()){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

    }
}
