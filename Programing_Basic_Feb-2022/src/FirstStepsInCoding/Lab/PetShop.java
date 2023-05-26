package FirstStepsInCoding.Lab;

import java.util.Scanner;

public class PetShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double priceDog = Double.parseDouble(scanner.nextLine());
        double priceCat = Double.parseDouble(scanner.nextLine());
        double finalPrice = priceCat*4 + priceDog*2.5;
        System.out.printf("%f lv.",finalPrice);

    }
}
