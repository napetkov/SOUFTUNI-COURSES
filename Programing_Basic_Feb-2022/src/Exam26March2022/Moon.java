package Exam26March2022;

import java.util.Scanner;

public class Moon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double averageSpeed = Double.parseDouble(scanner.nextLine());
        double fuelPer100Km = Double.parseDouble(scanner.nextLine());

        double hours = (2*384400)/averageSpeed+3;
        System.out.printf("%.0f%n",Math.ceil(hours));
        System.out.printf("%.0f",(2*384400/100.00*fuelPer100Km));



    }
}
