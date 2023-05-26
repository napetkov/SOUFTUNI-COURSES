package Arrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P05EvenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int sumOdd = 0;
        int sumEven = 0;
        for (int currentNumber:numbersArr) {
            if(currentNumber%2==0){
                sumEven+=currentNumber;
            }else{
                sumOdd+=currentNumber;
            }
        }
        System.out.println(sumEven-sumOdd);
    }
}
