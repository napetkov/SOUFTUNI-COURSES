package Exam19and20March2022;

import java.util.Scanner;

public class CourierExpress {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double weightShipment = Double.parseDouble(scanner.nextLine());
        String service = scanner.nextLine();
        int distance = Integer.parseInt(scanner.nextLine());
        double priceForKm = 0;
        switch (service) {
            case "standard":
                if (weightShipment > 0 && weightShipment < 1) {
                    priceForKm = 0.03;
                } else if (weightShipment > 1 && weightShipment < 10) {
                    priceForKm = 0.05;
                } else if (weightShipment >= 10 && weightShipment < 40) {
                    priceForKm = 0.10;
                } else if (weightShipment >= 40 && weightShipment < 90) {
                    priceForKm = 0.15;
                } else if (weightShipment >= 90 && weightShipment <= 150) {
                    priceForKm = 0.20;
                }
                break;
            case "express":
                if (weightShipment > 0 && weightShipment < 1) {
                    priceForKm = 0.03 + (0.03 * (0.80 * weightShipment));
                } else if (weightShipment > 1 && weightShipment < 10) {
                    priceForKm = 0.05 + (0.05 * (0.40 * weightShipment));
                } else if (weightShipment >= 10 && weightShipment < 40) {
                    priceForKm = 0.10 + (0.10 * (0.05 * weightShipment));
                } else if (weightShipment >= 40 && weightShipment < 90) {
                    priceForKm = 0.15 + (0.15 * (0.02 * weightShipment));
                } else if (weightShipment >= 90 && weightShipment <= 150) {
                    priceForKm = 0.20 + (0.20 * (0.01 * weightShipment));
                }
                break;
        }

        System.out.printf("The delivery of your shipment with weight of %.3f kg. would cost %.2f lv.", weightShipment, priceForKm * distance);
    }
}
