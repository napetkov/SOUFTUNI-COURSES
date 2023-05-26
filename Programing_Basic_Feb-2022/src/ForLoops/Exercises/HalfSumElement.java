package ForLoops.Exercises;

import java.util.Scanner;

public class HalfSumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int totalSum = 0;
        int maxNum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            totalSum += num;
            if (maxNum < num) {
                maxNum = num;
            }
        }
        sum = totalSum-maxNum;
        if (maxNum == sum) {
            System.out.println("Yes");
            System.out.printf("Sum = %d", sum);
        } else {
            System.out.println("No");
            System.out.printf("Diff = %d", Math.abs(sum - maxNum));
        }

    }
}
