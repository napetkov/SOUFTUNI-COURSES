package DataTypesAndVariables.MoreExercises;

import java.util.Scanner;

public class P02FromLeftToTheRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long number = Integer.parseInt(scanner.nextLine());
        int countSymbol = 0;

        for (int i = 0; i < number; i++) {
            String firstNumber = "";
            String secondNumber = "";
            long intFirstNumber = 0;
            long intSecondNumber = 0;
            String input = scanner.nextLine();
            for (int j = 0; j < input.length(); j++) {
                char currentSymbolFirstNumber = input.charAt(j);
                if (currentSymbolFirstNumber == ' ') {
                    countSymbol = j + 1;
                    break;
                }
                firstNumber += currentSymbolFirstNumber;
            }
            for (int j = countSymbol; j < input.length(); j++) {
                char currentSymbolSecondNumber = input.charAt(j);
                secondNumber += Character.toString(currentSymbolSecondNumber);
            }
            intFirstNumber = Long.parseLong(firstNumber);
            intSecondNumber = Long.parseLong(secondNumber);
            int sum = 0;
            if (intFirstNumber > intSecondNumber) {
                while (intFirstNumber != 0) {
                    long digit = Math.abs(intFirstNumber % 10);
                    sum += digit;
                    intFirstNumber = intFirstNumber / 10;
                }

            } else {
                while (intSecondNumber != 0) {
                    long digit = Math.abs(intSecondNumber % 10);
                    sum += digit;
                    intSecondNumber = intSecondNumber / 10;
                }
            }
            System.out.println(sum);
        }
    }
}
