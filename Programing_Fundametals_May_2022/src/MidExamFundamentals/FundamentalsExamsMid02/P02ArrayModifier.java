package MidExamFundamentals.FundamentalsExamsMid02;

import java.util.Arrays;
import java.util.Scanner;

public class P02ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numberArray = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] commandLine = input.split(" ");

            String command = commandLine[0];

            switch (command) {
                case "swap":
                    int index1 = Integer.parseInt(commandLine[1]);
                    int index2 = Integer.parseInt(commandLine[2]);
                    int elementToSwap = numberArray[index1];
                    numberArray[index1] = numberArray[index2];
                    numberArray[index2] = elementToSwap;
                    break;
                case "multiply":
                    index1 = Integer.parseInt(commandLine[1]);
                    index2 = Integer.parseInt(commandLine[2]);
                    numberArray[index1] = numberArray[index1]*numberArray[index2];
                    break;
                case "decrease":
                    for (int i = 0; i < numberArray.length; i++) {
                        numberArray[i]--;
                    }
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println(Arrays.toString(numberArray).replaceAll("[\\[\\]]",""));

    }
}
