package ExamsPractis.Exam18And19July2020;

import java.util.Scanner;

public class AddBags {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double priceOver20kg = Double.parseDouble(scanner.nextLine());
        double weight = Double.parseDouble(scanner.nextLine());
        int daysToTrip = Integer.parseInt(scanner.nextLine());
        int baggageNum = Integer.parseInt(scanner.nextLine());
        double price = 0;


        if (daysToTrip > 30) {
            if (weight < 10) {
                price = priceOver20kg * 0.20;
            } else if (weight >= 10 && weight <= 20) {
                price = priceOver20kg * 0.50;
            } else if (weight > 20) {
                price = priceOver20kg;
            }
            price = price * 1.10;
        } else if (daysToTrip <= 30 && daysToTrip >= 7) {
            if (weight < 10) {
                price = priceOver20kg * 0.20;
            } else if (weight >= 10 && weight <= 20) {
                price = priceOver20kg * 0.50;
            } else if (weight > 20) {
                price = priceOver20kg;
            }
            price = price * 1.15;
        } else if (daysToTrip < 7) {
            if (weight < 10) {
                price = priceOver20kg * 0.20;
            } else if (weight >= 10 && weight <= 20) {
                price = priceOver20kg * 0.50;
            } else if (weight > 20) {
                price = priceOver20kg;
            }
            price = price * 1.40;
        }
        System.out.printf("The total price of bags is: %.2f lv.", price * baggageNum);
    }
}
