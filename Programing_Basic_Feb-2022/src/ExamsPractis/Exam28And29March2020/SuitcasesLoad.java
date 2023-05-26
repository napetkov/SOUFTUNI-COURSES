package ExamsPractis.Exam28And29March2020;

import java.util.Scanner;

public class SuitcasesLoad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double capacity = Double.parseDouble(scanner.nextLine());
        String input = scanner.nextLine();
        int counter = 0;


        while (!input.equals("End")) {
            double suitcaseVolume = Double.parseDouble(input);
            counter++;
            if (counter % 3 == 0) {
                suitcaseVolume = suitcaseVolume * 1.10;
            }
            if (capacity < suitcaseVolume) {
                counter--;
                System.out.println("No more space!");
                break;
            }
            capacity -= suitcaseVolume;
            input = scanner.nextLine();
        }
        if (input.equals("End")) {
            System.out.println("Congratulations! All suitcases are loaded!");
        }
        System.out.printf("Statistic: %d suitcases loaded.",counter);

    }
}
