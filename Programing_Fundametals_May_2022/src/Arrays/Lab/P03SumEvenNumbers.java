package Arrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P03SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine();
        int[] numbersArr = Arrays.stream(inputLine.split(" "))
                .   mapToInt(Integer::parseInt)
                .toArray();
        int sumEvenNumbers = 0;
        for (int i = 0; i < numbersArr.length; i++) {
            int currentElement = numbersArr[i];
            if(currentElement%2==0){
                sumEvenNumbers+=currentElement;
            }
        }
        System.out.println(sumEvenNumbers);



    }
}
