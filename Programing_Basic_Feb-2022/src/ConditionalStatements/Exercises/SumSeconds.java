package ConditionalStatements.Exercises;

import java.util.Scanner;

public class SumSeconds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int timeFirst = Integer.parseInt(scanner.nextLine());
        int timeSecond = Integer.parseInt(scanner.nextLine());
        int timeThird = Integer.parseInt(scanner.nextLine());

        int timeSum = timeFirst + timeSecond + timeThird;
        int timeSumMin = timeSum / 60;
        int timeSumSec = timeSum % 60;

        if (timeSumSec < 10) {
            System.out.printf("%d:0%d", timeSumMin, timeSumSec);
        } else {

            System.out.printf("%d:%d", timeSumMin, timeSumSec);
        }


    }
}
