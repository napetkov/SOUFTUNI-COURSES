package ConditionalStatementsAdvanced.Exercises;

import java.util.Scanner;

public class OnTimeForTheExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int examHour = Integer.parseInt(scanner.nextLine());
        int examMin = Integer.parseInt(scanner.nextLine());
        int arrivedHour = Integer.parseInt(scanner.nextLine());
        int arrivedMin = Integer.parseInt(scanner.nextLine());

        int examAllMin = examHour * 60 + examMin;
        int arrivedAllMin = arrivedHour * 60 + arrivedMin;
        int diff = Math.abs(examAllMin - arrivedAllMin);
        int hour = diff / 60;
        int min = diff % 60;
        if (arrivedAllMin > examAllMin) {
            System.out.println("Late");
            if (diff <= 59) {
                System.out.printf("%d minutes after the start", diff);
            } else {
                System.out.printf("%d:%02d hours after the start", hour,min);
            }
        } else if (arrivedAllMin == examAllMin || diff <= 30) {
            System.out.println("On time");
            if (diff != 0) {
                System.out.printf("%d minutes before the start", diff);
            }
        } else {
            System.out.println("Early");
            if (diff <= 59) {
                System.out.printf("%d minutes before the start", diff);
            } else {
                System.out.printf("%d:%02d hours before the start", hour,min);
            }
        }

    }
}
