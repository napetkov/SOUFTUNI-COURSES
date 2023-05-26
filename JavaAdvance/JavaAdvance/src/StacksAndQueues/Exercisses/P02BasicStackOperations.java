package StacksAndQueues.Exercisses;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P02BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] inputLine = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int numbersOfPushElements = inputLine[0];
        int numbersOfPopElements = inputLine[1];
        int elementToCheck = inputLine[2];

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < numbersOfPushElements; i++) {
            stack.push(numbers[i]);
        }
        for (int i = 0; i < numbersOfPopElements; i++) {
            stack.pop();
        }
       if(stack.isEmpty()){
           System.out.println("0");
       }else if(stack.contains(elementToCheck)){
           System.out.println("true");
       }else{
          // int minElement = stack.stream().mapToInt(e->e).min().getAsInt();
           int minElement = Collections.min(stack);
           System.out.println(minElement);
       }
    }
}
