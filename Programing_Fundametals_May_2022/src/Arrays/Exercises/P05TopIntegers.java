package Arrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P05TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputLine = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int i = 0; i < inputLine.length; i++) {
            boolean isBigger = false;
            int currentInt = inputLine[i];
            for (int j = i + 1; j < inputLine.length; j++) {
                isBigger = false;
                int compareInt = inputLine[j];
                if (currentInt > compareInt) {
                    isBigger = true;
                } else {
                    break;
                }
            }
            if (isBigger) {
                System.out.printf("%d ", currentInt);
            }
        }
        System.out.println(inputLine[inputLine.length-1]);
    }
}
