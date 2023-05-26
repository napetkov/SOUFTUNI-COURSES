package WhileLoop.Exercises;

import java.util.Scanner;

public class ExamPreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberPoorGrade = Integer.parseInt(scanner.nextLine());
        boolean isEnough = false;
        int numberProblems = 0;
        int counterPoorGrade = 0;
        double sumGrade = 0;
        String lastProblem = "";
        String problemsName = scanner.nextLine();
        while (!problemsName.equals("Enough")) {
            int grade = Integer.parseInt(scanner.nextLine());
            if (grade <= 4) {
                counterPoorGrade++;
            }
            if (counterPoorGrade >= numberPoorGrade) {
                isEnough = true;
                break;
            }
            numberProblems++;
            sumGrade += grade;
            lastProblem = problemsName;
            problemsName = scanner.nextLine();
        }
        if (isEnough) {
            System.out.printf("You need a break, %d poor grades.", counterPoorGrade);
        } else {
            System.out.printf("Average score: %.2f%nNumber of problems: %d%nLast problem: %s", sumGrade / numberProblems, numberProblems, lastProblem);
        }

    }
}
