package ConditionalStatements.MoreExercises;

import java.util.Scanner;

public class PipesInPool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int v = Integer.parseInt(scanner.nextLine());
        int p1 = Integer.parseInt(scanner.nextLine());
        int p2 = Integer.parseInt(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());
        double vWater = p1 * h + p2 * h;
        double percentageP1 = ((p1 * h) / vWater) * 100;
        double percentageP2 = ((p2 * h) / vWater) * 100;
        double percentageV = (vWater / v) * 100;
        if (vWater <= v) {

            System.out.print("The pool is " + String.format("%.2f",percentageV) + "% full. Pipe 1: " + String.format("%.2f",percentageP1) + "%. Pipe 2: " + String.format("%.2f",percentageP2) + "%.");
            //System.out.printf("The pool is %.2f'%' full. Pipe 1: %.2f'%'. Pipe 2: %.2f'%'", (vWater / v) * 100, ((p1 * h) / vWater) * 100, ((p2 * h) / vWater) * 100);
        } else {
            System.out.printf("For %.2f hours the pool overflows with %.2f liters", h, (vWater - v));
        }


    }
}
