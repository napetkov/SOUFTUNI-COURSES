package ExamsPractis.Exam9and10March2019;

import java.util.Scanner;

public class FitnessCenter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int visitors = Integer.parseInt(scanner.nextLine());
        int countBack = 0;
        int countChest = 0;
        int countLegs = 0;
        int countAbs = 0;
        int countProteinShake = 0;
        int countProteinBar = 0;
        for (int i = 1; i <= visitors; i++) {
            String input = scanner.nextLine();
            switch (input) {
                case "Back":
                    countBack++;
                    break;
                case "Chest":
                    countChest++;
                    break;
                case "Legs":
                    countLegs++;
                    break;
                case "Abs":
                    countAbs++;
                    break;
                case "Protein shake":
                    countProteinShake++;
                    break;
                case "Protein bar":
                    countProteinBar++;
                    break;
            }
        }
        System.out.printf("%d - back%n",countBack);
        System.out.printf("%d - chest%n",countChest);
        System.out.printf("%d - legs%n",countLegs);
        System.out.printf("%d - abs%n",countAbs);
        System.out.printf("%d - protein shake%n",countProteinShake);
        System.out.printf("%d - protein bar%n",countProteinBar);
        System.out.printf("%.2f%% - work out%n",(countAbs+countBack+countChest+countLegs)*1.00/visitors*100.00);
        System.out.printf("%.2f%% - protein",(countProteinBar+countProteinShake)*1.00/visitors*100.00);


    }
}
