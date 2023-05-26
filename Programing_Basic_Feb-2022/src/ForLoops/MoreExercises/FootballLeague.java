package ForLoops.MoreExercises;

import java.util.Scanner;

public class FootballLeague {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int capacity = Integer.parseInt(scanner.nextLine());
        int allFans = Integer.parseInt(scanner.nextLine());
        int fansSectorA = 0;
        int fansSectorB = 0;
        int fansSectorV = 0;
        int fansSectorG = 0;
        for (int i = 0; i < allFans; i++) {
            String sectors = scanner.nextLine();
            switch (sectors){
                case "A":
                    fansSectorA++;
                    break;
                case "B":
                    fansSectorB++;
                    break;
                case "V":
                    fansSectorV++;
                    break;
                case "G":
                    fansSectorG++;
                    break;
            }

        }
        System.out.printf("%.2f%%%n",fansSectorA*1.00/allFans*100);
        System.out.printf("%.2f%%%n",fansSectorB*1.00/allFans*100);
        System.out.printf("%.2f%%%n",fansSectorV*1.00/allFans*100);
        System.out.printf("%.2f%%%n",fansSectorG*1.00/allFans*100);
        System.out.printf("%.2f%%",allFans*1.00/capacity*100);
    }
}
