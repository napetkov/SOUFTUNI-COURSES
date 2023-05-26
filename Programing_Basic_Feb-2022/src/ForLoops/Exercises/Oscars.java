package ForLoops.Exercises;

import java.util.Scanner;

public class Oscars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nameActor = scanner.nextLine();
        double pointsAcademy = Double.parseDouble(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        double sumPoints = pointsAcademy;
        for (int i = 0; i < n; i++) {
            String evaluator = scanner.nextLine();
            double points = Double.parseDouble(scanner.nextLine());
            sumPoints += (evaluator.length() * points) / 2;

            if (sumPoints >= 1250.5) {
                System.out.printf("Congratulations, %s got a nominee for leading role with %.1f!", nameActor, sumPoints);
                break;
            }
        }
       if(sumPoints<1250.5){
           System.out.printf("Sorry, %s you need %.1f more!", nameActor, 1250.5 - sumPoints);
       }
    }
}


