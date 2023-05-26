package ConditionalStatementsAdvanced.Exercises;

import java.util.Scanner;

public class SummerOutfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int degrees = Integer.parseInt(scanner.nextLine());
        String time = scanner.nextLine();
        String outfit = "";
        String shoes = "";
        if (degrees >= 10 && degrees <= 18) {
            switch (time) {//                    System.out.printf("It's %d degrees, get your %s and %s.", degrees, outfit, shoes);
                case "Morning":
                    outfit = "Sweatshirt";
                    shoes = "Sneakers";
                    break;
//                    System.out.printf("It's %d degrees, get your %s and %s.", degrees, outfit, shoes);
                case "Afternoon":
                    outfit = "Shirt";
                    shoes = "Moccasins";
                    break;
//                    System.out.printf("It's %d degrees, get your %s and %s.", degrees, outfit, shoes);
                case "Evening":
                    outfit = "Shirt";
                    shoes = "Moccasins";
                    break;
            }
        } else if (degrees > 18 && degrees <= 24) {
            switch (time) {
                case "Morning":
                    outfit = "Shirt";
                    shoes = "Moccasins";
//                    System.out.printf("It's %d degrees, get your %s and %s.", degrees,outfit,shoes);
                    break;
                case "Afternoon":
                    outfit = "T-Shirt";
                    shoes = "Sandals";
//                    System.out.printf("It's %d degrees, get your %s and %s.", degrees,outfit,shoes);
                    break;
                case "Evening":
                    outfit = "Shirt";
                    shoes = "Moccasins";
//                    System.out.printf("It's %d degrees, get your %s and %s.", degrees,outfit,shoes);
                    break;

            }
        } else if (degrees >= 25) {
            switch (time) {
                case "Morning":
                    outfit = "T-Shirt";
                    shoes = "Sandals";
//                    System.out.printf("It's %d degrees, get your %s and %s.", degrees,outfit,shoes);
                    break;
                case "Afternoon":
                    outfit = "Swim Suit";
                    shoes = "Barefoot";
//                    System.out.printf("It's %d degrees, get your %s and %s.", degrees,outfit,shoes);
                    break;
                case "Evening":
                    outfit = "Shirt";
                    shoes = "Moccasins";
//                    System.out.printf("It's %d degrees, get your %s and %s.", degrees,outfit,shoes);
                    break;
            }
        }
        System.out.printf("It's %d degrees, get your %s and %s.", degrees, outfit, shoes);

    }
}
