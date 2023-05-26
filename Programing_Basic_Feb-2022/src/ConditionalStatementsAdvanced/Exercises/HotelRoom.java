package ConditionalStatementsAdvanced.Exercises;

import java.util.Scanner;

public class HotelRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String month = scanner.nextLine();
        int nights = Integer.parseInt(scanner.nextLine());
        double studioPrice = 0;
        double apartmentPrice = 0;
        double totalPriceStudio = 0;
        double totalPriceApartment = 0;

        switch (month) {
            case "May":
            case "October":
                studioPrice = 50.00;
                apartmentPrice = 65.00;
                break;
            case "June":
            case "September":
                studioPrice = 75.20;
                apartmentPrice = 68.70;
                break;
            case "July":
            case "August":
                studioPrice = 76.00;
                apartmentPrice = 77.00;
                break;
        }

        if ((nights > 7 && nights <= 14) && (month.equals("May") || month.equals("October"))) {
            studioPrice = studioPrice * 0.95;
        } else if (nights > 14) {
            if (month.equals("May") || month.equals("October")) {
                studioPrice = studioPrice * 0.70;
            } else if (month.equals("June") || month.equals("September")) {
                studioPrice = studioPrice * 0.80;
            }

            apartmentPrice = apartmentPrice * 0.90;

        }
        totalPriceApartment = (nights * apartmentPrice);
        totalPriceStudio = (nights * studioPrice);

        System.out.printf("Apartment: %.2f lv.", totalPriceApartment);
        System.out.println();
        System.out.printf("Studio: %.2f lv.", totalPriceStudio);
    }
}
