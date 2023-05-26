package ExamPerparation;

import java.util.Scanner;

public class Gymnastics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String country = scanner.nextLine();
        String device = scanner.nextLine();
        double difficulty = 0;
        double performance = 0;
        switch (country) {
            case "Russia":
                switch (device) {
                    case "ribbon":
                        difficulty = 9.10;
                        performance = 9.4;
                        break;
                    case "hoop":
                        difficulty = 9.30;
                        performance = 9.80;
                        break;
                    case "rope":
                        difficulty = 9.60;
                        performance = 9.00;
                        break;
                }
                break;
            case "Bulgaria":
                switch (device) {
                    case "ribbon":
                        difficulty = 9.60;
                        performance = 9.4;
                        break;
                    case "hoop":
                        difficulty = 9.550;
                        performance = 9.750;
                        break;
                    case "rope":
                        difficulty = 9.50;
                        performance = 9.40;
                        break;
                }
                break;
            case "Italy":
                switch (device) {
                    case "ribbon":
                        difficulty = 9.20;
                        performance = 9.50;
                        break;
                    case "hoop":
                        difficulty = 9.450;
                        performance = 9.350;
                        break;
                    case "rope":
                        difficulty = 9.70;
                        performance = 9.150;
                        break;
                }
                break;
        }
        double totalAssessment = difficulty+performance;
        double percent = ((20-totalAssessment)/20)*100;

        System.out.printf("The team of %s get %.3f on %s.%n%.2f%%",country,totalAssessment,device,percent);

    }
}
