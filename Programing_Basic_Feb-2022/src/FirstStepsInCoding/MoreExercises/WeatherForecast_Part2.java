package FirstStepsInCoding.MoreExercises;

import java.util.Scanner;

public class WeatherForecast_Part2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double celsius = Double.parseDouble(scanner.nextLine());

        if (celsius < 35) {
            if (celsius >= 26) {
                System.out.println("Hot");
            } else if (celsius >= 20.1) {
                System.out.println("Warm");
            } else if (celsius >= 15) {
                System.out.println("Mild");
            } else if (celsius >= 12) {
                System.out.println("Cool");
            } else if (celsius >= 5) {
                System.out.println("Cold");
            } else {
                System.out.println("unknown");
            }


        } else {
            System.out.println("unknown");
        }


    }
}
