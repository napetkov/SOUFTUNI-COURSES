package Arrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P08MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputLine = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int sumOfElements = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < inputLine.length; i++) {
            int firstElement = inputLine[i];
            for (int j = i; j < inputLine.length; j++) {
                int secondElement = inputLine[j];
                if(i==j){
                    continue;
                }
                if(firstElement+secondElement==sumOfElements){
                    System.out.println(firstElement+" "+secondElement);

                }

            }

        }

    }
}
