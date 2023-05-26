package ConditionalStatements.Exercises;

import java.util.Scanner;

public class LunchBreak {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String seriesName = scanner.nextLine();
        int seriesTime = Integer.parseInt(scanner.nextLine());
        int breakTime = Integer.parseInt(scanner.nextLine());

        double lunchTime = breakTime * 0.125;
        double restTime = breakTime * 0.25;
        double leftTime = breakTime - (lunchTime + restTime);
        // double timeToWatch = breakTime - breakTime * 0.375;

        double differenceTime = Math.abs(leftTime - seriesTime);
        differenceTime = Math.ceil(differenceTime);
//или може да сезамести направо в аргумента на printf,за да се избегне още еднапроменлива
        if (leftTime >= seriesTime) {
            System.out.printf("You have enough time to watch %s and left with %.0f minutes free time.", seriesName, differenceTime);
        } else {
            System.out.printf("You don't have enough time to watch %s, you need %.0f more minutes.", seriesName, differenceTime);

        }


    }
}
