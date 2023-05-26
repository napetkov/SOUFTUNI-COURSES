package ConditionalStatementsAdvanced.MoreExercises;

import java.util.Scanner;


public class SchoolCamp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String season = scanner.nextLine();
        String groupType = scanner.nextLine();
        int countStudents = Integer.parseInt(scanner.nextLine());
        int countNights = Integer.parseInt(scanner.nextLine());
        double priceNights = 0;
        double totalPrice = 0;
        String sports = "";

        if ("Winter".equals(season)) {
            switch (groupType) {
                case "girls":
                    priceNights = 9.60;
                    sports = "Gymnastics";
                    break;
                case "boys":
                    priceNights = 9.60;
                    sports = "Judo";
                    break;
                case "mixed":
                    priceNights = 10.00;
                    sports = "Ski";
                    break;
            }
        } else if ("Spring".equals(season)) {
            switch (groupType) {
                case "girls":
                    priceNights = 7.20;
                    sports = "Athletics";
                    break;
                case "boys":
                    priceNights = 7.20;
                    sports = "Tennis";
                    break;
                case "mixed":
                    priceNights = 9.50;
                    sports = "Cycling";
                    break;
            }
        } else if ("Summer".equals(season)) {
            switch (groupType) {
                case "girls":
                    priceNights = 15.00;
                    sports = "Volleyball";
                    break;
                case "boys":
                    priceNights = 15;
                    sports = "Football";
                    break;
                case "mixed":
                    priceNights = 20;
                    sports = "Swimming";
                    break;
            }
        }
        totalPrice = countStudents * countNights * priceNights;
        if (countStudents >= 50) {
            totalPrice = totalPrice - totalPrice * 0.50;
        } else if (countStudents >= 20 && countStudents < 50) {
            totalPrice = totalPrice - totalPrice * 0.15;
        } else if (countStudents >= 10 && countStudents < 20) {
            totalPrice = totalPrice - totalPrice * 0.05;
        }

        System.out.printf("%s %.2f lv.", sports, totalPrice);
    }
}
