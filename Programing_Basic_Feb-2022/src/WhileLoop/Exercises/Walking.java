package WhileLoop.Exercises;

import java.util.Scanner;

public class Walking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int sumSteps = 0;

        while (!input.equals("Going home")) {
            int steps = Integer.parseInt(input);
            sumSteps += steps;
            if (sumSteps >= 10000) {
                break;
            }
            input = scanner.nextLine();
        }
        if(input.equals("Going home")){
            int stepsToHome = Integer.parseInt(scanner.nextLine());
            sumSteps += stepsToHome;
        }
        if (sumSteps < 10000) {

            System.out.printf("%d more steps to reach goal.", Math.abs(10000 - sumSteps));
        }else{
            System.out.printf("Goal reached! Good job!%n%d steps over the goal!", Math.abs(sumSteps - 10000));
        }


    }
}
