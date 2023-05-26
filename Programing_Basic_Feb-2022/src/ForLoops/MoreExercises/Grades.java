package ForLoops.MoreExercises;

import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberStudents = Integer.parseInt(scanner.nextLine());
        double totalRate = 0;
        double topStudents = 0;
        double veryGoodStudents = 0;
        double goodStudents = 0;
        double failedStudents = 0;
        for (int i = 0; i < numberStudents; i++) {
            double rate = Double.parseDouble(scanner.nextLine());
            totalRate += rate;
            if (rate >= 5) {
                topStudents++;
            } else if (rate >= 4) {
                veryGoodStudents++;
            } else if (rate >= 3) {
                goodStudents++;
            } else {
                failedStudents++;
            }
        }
        System.out.printf("Top students: %.2f%%%n",topStudents/numberStudents*100);
        System.out.printf("Between 4.00 and 4.99: %.2f%%%n",veryGoodStudents/numberStudents*100);
        System.out.printf("Between 3.00 and 3.99: %.2f%%%n",goodStudents/numberStudents*100);
        System.out.printf("Fail: %.2f%%%n",failedStudents/numberStudents*100);
        System.out.printf("Average: %.2f",totalRate/numberStudents);

    }
}
