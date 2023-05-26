package FirstStepsInCoding.Exercises;

import java.util.Scanner;

public class fishTank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        1.	Дължина в см – цяло число в интервала [10 … 500]
//        2.	Широчина в см – цяло число в интервала [10 … 300]
//        3.	Височина в см – цяло число в интервала [10… 200]
//        4.	Процент  – реално число в интервала [0.000 … 100.000]

        double length = Double.parseDouble(scanner.nextLine())/10;
        double width = Double.parseDouble(scanner.nextLine())/10;
        double height = Double.parseDouble(scanner.nextLine())/10;
        double percentage = Double.parseDouble(scanner.nextLine())/100;
        double volume = length * width * height;
        double volumeSands = volume * percentage;
        double volumeWater = volume-volumeSands;
        System.out.println(volumeWater);


    }
}
