package Arrays.MoreExercises;

import java.util.Arrays;
import java.util.Scanner;

public class P01EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStrings = Integer.parseInt(scanner.nextLine());

        int[] printArray = new int[numberOfStrings];

        for (int i = 0; i < numberOfStrings; i++) {
            int sumOfElements = 0;
           String text = scanner.nextLine();

            for (int j = 0; j < text.length(); j++) {

                int element = text.charAt(j);

                if (isVowels(element)) {
                    element = element * text.length();
                } else {
                    element = element / text.length();
                }
                sumOfElements += element;
            }
            printArray[i] = sumOfElements;

        }
        Arrays.sort(printArray);
        for (int currentElement:printArray) {
            System.out.println(currentElement);

        }

    }

    private static boolean isVowels(int c) {
        return c == 97 || c == 65 || c == 69 || c == 101 || c == 105 || c == 73 || c == 79 || c == 111 || c == 117 || c == 85 ;
    }
}
