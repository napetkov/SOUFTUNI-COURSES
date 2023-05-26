package Arrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P03ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] firstArr = new String[n];
        String[] secondArr = new String[n];

        for (int i = 0; i < n; i++) {
            String[] inputLine = scanner.nextLine().split(" ");
            if (i==0||i % 2 == 0) {
                firstArr[i] = inputLine[0];
                secondArr[i] = inputLine[1];
            } else {
                secondArr[i] = inputLine[0];
                firstArr[i] = inputLine[1];
            }
        }
        System.out.println(String.join(" ",firstArr));
        System.out.println(String.join(" ",secondArr));
    }
}
