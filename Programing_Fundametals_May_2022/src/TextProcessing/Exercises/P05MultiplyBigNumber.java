package TextProcessing.Exercises;

import java.math.BigInteger;
import java.util.Scanner;

public class P05MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//
//        BigInteger firstNumber = new BigInteger(scanner.nextLine());
//        BigInteger secondNumber = new BigInteger(scanner.nextLine());
//
//        System.out.println(firstNumber.multiply(secondNumber));

        String[] bigNumber = scanner.nextLine().split("");
        int number = Integer.parseInt(scanner.nextLine());
        StringBuilder result = new StringBuilder();
        int multiplyResult = 0;
        int firstDigit = 0;
        int secondDigit = 0;
        for (String digit : bigNumber) {
            int currentDigit = Integer.parseInt(digit);
            multiplyResult = number * currentDigit;
            multiplyResult = multiplyResult + firstDigit;

            firstDigit = multiplyResult / 10;

            secondDigit = multiplyResult % 10;
            result.append(secondDigit);
        }
        result.append(secondDigit);
        result.append(firstDigit);
        result.reverse();
        System.out.println(result);


    }
}
