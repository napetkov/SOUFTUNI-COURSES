package FirstStepsInCoding.Exercises;

import java.util.Scanner;

public class SuppliesForSchool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int penPac = Integer.parseInt(scanner.nextLine());
        int markersPac = Integer.parseInt(scanner.nextLine());
        int detergent = Integer.parseInt(scanner.nextLine());
        int discount = Integer.parseInt(scanner.nextLine());
        double priceWithoutDisount = penPac * 5.8 + markersPac * 7.2 + detergent * 1.2;
        double discountPrice = priceWithoutDisount * discount/100;
        double priceWithDiscount = priceWithoutDisount - discountPrice;
        System.out.println(priceWithDiscount);

    }
}
