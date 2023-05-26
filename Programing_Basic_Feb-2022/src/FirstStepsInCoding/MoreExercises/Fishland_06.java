package FirstStepsInCoding.MoreExercises;

import java.util.Scanner;

public class Fishland_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //System.out.print("Цена Скумрия/кг:");
        double mackerelPriceKg = Double.parseDouble(scanner.nextLine());
        //System.out.print("Цена Цаца/кг:");
        double spratFishPriceKg = Double.parseDouble(scanner.nextLine());
        //System.out.print("Паламуд кг:");
        double bonitoKg = Double.parseDouble(scanner.nextLine());
        //System.out.print("Сафрид кг:");
        double horseMackerelKg = Double.parseDouble(scanner.nextLine());
        //System.out.print("Миди кг:");
        int mussels = Integer.parseInt(scanner.nextLine());
        //•	Паламуд – 60% по-скъп от скумрията
        //•	Сафрид – 80% по-скъп от цацата
        //•	Миди – 7.50 лв. за килограм
        double finalPrice = (mackerelPriceKg*1.6)*bonitoKg + (spratFishPriceKg * 1.8)*horseMackerelKg + mussels*7.5;
        System.out.printf("%.2f",finalPrice);




    }
}
