package BasicSyntaxConditionalStatementsAndLoops.Lab;

import java.util.Scanner;

public class P13RefactorSumOfOddNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int product = 2 * i + 1;
            System.out.println(product);
            sum += product;
        }
        System.out.printf("Sum: %d%n", sum);

    }
}
