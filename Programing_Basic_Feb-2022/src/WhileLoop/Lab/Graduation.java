package WhileLoop.Lab;

import java.util.Scanner;

public class Graduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        double totalGrade = 0;
        double poorGrades = 0;
        int grade = 1;
        while (grade <= 12) {
            double yearGrade = Double.parseDouble(scanner.nextLine());
            if (yearGrade >= 4) {
                grade++;
                totalGrade += yearGrade;
            } else {
                poorGrades++;
                if (poorGrades > 1) {
                    System.out.printf("%s has been excluded at %d grade", name, grade);
                    break;
                }
            }
        }
        if(grade>12){
            System.out.printf("%s graduated. Average grade: %.2f", name, totalGrade / 12);
        }
    }
}
