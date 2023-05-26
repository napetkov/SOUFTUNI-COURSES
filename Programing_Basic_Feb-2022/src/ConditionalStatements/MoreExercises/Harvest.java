package ConditionalStatements.MoreExercises;

import java.util.Scanner;

public class Harvest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//x - общо кв.м;    y - грозде на кв.м;     z - нужни литри вино;
        double x = Integer.parseInt(scanner.nextLine());
        double y = Double.parseDouble(scanner.nextLine());
        int z = Integer.parseInt(scanner.nextLine());
        int workers = Integer.parseInt(scanner.nextLine());
        x = x * 0.4;
        double wineLiters = (x * y) / 2.5;

        if (wineLiters < z) {
            System.out.printf("It will be a tough winter! More %.0f liters wine needed.",Math.floor(z-wineLiters));
        }else {
            System.out.printf("Good harvest this year! Total wine: %.0f liters.",Math.floor(wineLiters));
            System.out.println();
            System.out.printf("%.0f liters left -> %.0f liters per person.",Math.ceil(wineLiters-z),Math.ceil((wineLiters-z)/workers));
        }


    }
}
