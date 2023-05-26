package BasicSyntaxConditionalStatementsAndLoops.Exercises;

import java.util.Scanner;

public class P04PrintAndSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        for (int i = firstNumber; i <= secondNumber; i++) {
            System.out.printf("%d ",i);
            sum += i;
        }
        System.out.printf("%nSum: %d",sum);
    }
}
