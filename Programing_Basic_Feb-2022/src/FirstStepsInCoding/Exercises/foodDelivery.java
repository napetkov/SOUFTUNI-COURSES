package FirstStepsInCoding.Exercises;

import java.util.Scanner;

public class foodDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int chickenMenu = Integer.parseInt(scanner.nextLine());
        int fishMenu = Integer.parseInt(scanner.nextLine());
        int vegiMenu = Integer.parseInt(scanner.nextLine());
        double dessert = (chickenMenu*10.35 + fishMenu*12.4 + vegiMenu*8.15)*0.2;
        double finalbill = (chickenMenu*10.35 + fishMenu*12.4 + vegiMenu*8.15)+dessert+2.5;
        System.out.println(finalbill);
    }
}
