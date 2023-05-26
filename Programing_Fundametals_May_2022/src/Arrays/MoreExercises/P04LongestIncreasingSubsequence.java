package Arrays.MoreExercises;

import java.util.Arrays;
import java.util.Scanner;

public class P04LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int[] subNumbers = new int[numbers.length];


        for (int i = 0; i < numbers.length; i++) {
           if(i== numbers.length-1){
               break;
           }
            if(numbers[i]<numbers[i+1]){
               subNumbers[i] = numbers[i];
               subNumbers[i+1] = numbers[i+1];
            }else{
                subNumbers[i] = numbers[i+1];
            }

        }
        System.out.println(Arrays.toString(subNumbers));

    }
}
