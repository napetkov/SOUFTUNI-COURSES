package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P03DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNumber = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> binaryStack = new ArrayDeque<>();
        if(inputNumber==0){
            System.out.println("0");
        }else {

            while (inputNumber != 0) {
                binaryStack.push(inputNumber % 2);
                inputNumber = inputNumber / 2;

            }

            //binaryStack.forEach(System.out::print);
            while (!binaryStack.isEmpty()){
                System.out.print(binaryStack.pop());
            }
        }


    }
}
