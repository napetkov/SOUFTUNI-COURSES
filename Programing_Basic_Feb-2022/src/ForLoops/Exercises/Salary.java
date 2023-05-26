package ForLoops.Exercises;

import java.util.Scanner;

public class Salary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int salary = Integer.parseInt(scanner.nextLine());
        int sumWebSait = 0;
        for (int i = 0; i < n; i++) {
            String webSait = scanner.nextLine();
            switch (webSait) {
                case "Facebook":
                    sumWebSait += 150;
                    break;
                case "Instagram":
                    sumWebSait += 100;
                    break;
                case "Reddit":
                    sumWebSait += 50;
                    break;
            }

            if (sumWebSait >= salary) {
                System.out.printf("You have lost your salary.");
                break;
            }
        }
        if (sumWebSait < salary) {
            System.out.println(salary - sumWebSait);
        }


    }
}
