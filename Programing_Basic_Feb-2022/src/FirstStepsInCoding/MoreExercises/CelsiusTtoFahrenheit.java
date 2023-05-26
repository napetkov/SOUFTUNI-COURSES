package FirstStepsInCoding.MoreExercises;

import java.util.Scanner;

public class CelsiusTtoFahrenheit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //°F = °C × 1,8 + 32
         double celsius = Double.parseDouble(scanner.nextLine());
         double fahrenheit = (celsius * 1.8) + 32;
        System.out.printf("%.2f",fahrenheit);
    }
}
