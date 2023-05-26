package Arrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P07MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputLine = scanner.nextLine().split(" ");
        int counterSequence = 1;
        String maxElement = "";
        int maxCounter = 0;

        for (int i = 0; i < inputLine.length-1; i++) {
            String currentElement = inputLine[i];
            String nextElement = inputLine[i+1];
                if(currentElement.equals(nextElement)){
                    counterSequence +=1;
                    if(counterSequence>maxCounter){
                        maxCounter = counterSequence;
                        maxElement = currentElement;
                    }
                }else{
                    counterSequence = 1;
                }
        }
       String[] sequence = new String[maxCounter];
        for (int i = 0; i < sequence.length; i++) {
            sequence[i] = maxElement;
        }
        System.out.println(String.join(" ",sequence));
    }
}
