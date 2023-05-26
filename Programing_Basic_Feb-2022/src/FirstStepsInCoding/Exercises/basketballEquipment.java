package FirstStepsInCoding.Exercises;

import java.util.Scanner;

public class basketballEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        •	Баскетболни кецове – цената им е 40% по-малка от таксата за една година
//•	        Баскетболен екип – цената му е 20% по-евтина от тази на кецовете
//•	        Баскетболна топка – цената ѝ е 1 / 4 от цената на баскетболния екип
//•	        Баскетболни аксесоари – цената им е 1 / 5 от цената на баскетболната топка

        int taxForYear = Integer.parseInt(scanner.nextLine());
        double shoes = taxForYear * 0.60;
        double clothes = shoes * 0.80;
        double ball = clothes * 0.25;
        double accessories = ball * 0.20;
        double allEquiptment = taxForYear + shoes + clothes + ball + accessories;
        System.out.println(allEquiptment);



    }
}
