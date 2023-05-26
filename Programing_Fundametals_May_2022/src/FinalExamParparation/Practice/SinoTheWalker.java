package FinalExamParparation.Practice;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SinoTheWalker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] timeLeaves = scanner.nextLine().split(":");
        long steps = Long.parseLong(scanner.nextLine());
        long timeForStep = Long.parseLong(scanner.nextLine());

        long totalTimeInSec = Long.parseLong(timeLeaves[0]) * 60 * 60 +
                Long.parseLong(timeLeaves[1]) * 60 + Long.parseLong(timeLeaves[2]);
        long finalTime = totalTimeInSec + steps * timeForStep;

        long finalHoers = finalTime / 3600;
        long finalMinSec = finalTime % 3600;
        long finalMin = finalMinSec / 60;
        long finalSec = finalMinSec % 60;

        if (finalHoers > 23) {
            finalHoers = finalHoers % 24;
        }

        DecimalFormat timeToPrint = new DecimalFormat("00");


        StringBuilder print = new StringBuilder();
        print.append(timeToPrint.format(finalHoers));
        print.append(":");
        print.append(timeToPrint.format(finalMin));
        print.append(":");
        print.append(timeToPrint.format(finalSec));

        System.out.printf("Time Arrival: %s", print.toString());

    }
}
