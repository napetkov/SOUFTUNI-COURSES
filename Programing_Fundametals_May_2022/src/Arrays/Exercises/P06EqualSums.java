package Arrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P06EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputLine = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        boolean isEqual = false;
        for (int i = 0; i < inputLine.length; i++) {
            int leftSum = 0;
            int rightSum = 0;
            for (int j = 0; j <i; j++) {
                leftSum+=inputLine[j];
            }
            for (int j = i+1; j < inputLine.length ; j++) {
                rightSum+=inputLine[j];
            }
            if(leftSum==rightSum){
                System.out.printf("%d",i);
                isEqual = true;
            }
        }
        if(!isEqual&&inputLine.length!=1){
            System.out.println("no");
        }
    }
}
