package FinalExamParparation.Practice;

import java.util.Scanner;

public class SantasCookies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numBake = Integer.parseInt(scanner.nextLine());

        int totalCookiesForBoxesKG = 0;
        int totalCountOfCookies = 0;
        int totalBoxes = 0;

        for (int i = 0; i < numBake; i++) {
            int flourAmount = Integer.parseInt(scanner.nextLine());
            int sugarAmount = Integer.parseInt(scanner.nextLine());
            int cocoaAmount = Integer.parseInt(scanner.nextLine());
            int totalCookiesKG = 0;

            while (flourAmount >= 0 && sugarAmount >= 0 && cocoaAmount >= 0) {
                flourAmount -= 140;
                sugarAmount -= 20;
                cocoaAmount -= 10;
                totalCookiesKG += 170;

            }
            totalCookiesKG -= 170;
            totalCookiesForBoxesKG += totalCookiesKG;
            int countOfCookies = totalCookiesKG / 25;
            totalCountOfCookies+=countOfCookies;
            if (countOfCookies >= 5) {
                int countOfBoxes = countOfCookies / 5;
                totalBoxes +=countOfBoxes;
                System.out.printf("Boxes of cookies: %d%n", countOfBoxes);

            } else {
                System.out.println("Ingredients are not enough for a box of cookies.");
            }

        }
        int totalCountOfBoxes = totalCookiesForBoxesKG / 25 / 5;

        System.out.printf("Total boxes: %d", totalBoxes);
    }

}
