package TextProcessing.Exercises;

import java.util.Scanner;

public class P08LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().trim().split("\\s+");
        double totalSum = 0;
        for (String text : input) {
            double currentSum = 0;

            char firstLetter = text.charAt(0);
            char secondLetter = text.charAt(text.length() - 1);
            double currentNumber = Double.parseDouble(text.substring(1, text.length() - 1));

            if (Character.isLowerCase(firstLetter)) {
                int position = (int) firstLetter - 96;
                currentSum += currentNumber * position;
            } else {
                int position = (int) firstLetter - 64;
                currentSum += currentNumber / position;
            }
            if (Character.isLowerCase(secondLetter)) {
                int position = (int) secondLetter - 96;
                currentSum += position;

            } else {
                int position = (int) secondLetter - 64;
                currentSum -= position;

            }
            totalSum += currentSum;

        }
        System.out.printf("%.2f", totalSum);

    }
}
