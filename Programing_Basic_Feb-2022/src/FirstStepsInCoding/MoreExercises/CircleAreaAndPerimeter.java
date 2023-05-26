package FirstStepsInCoding.MoreExercises;

import java.util.Scanner;

public class CircleAreaAndPerimeter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double r = Double.parseDouble(scanner.nextLine());

        double area = Math.PI * (Math.pow(r, 2));
        double parameter = Math.PI * 2 * r;

        System.out.printf("%.2f", area);
        System.out.println();
        System.out.printf("%.2f", parameter);

    }
}
