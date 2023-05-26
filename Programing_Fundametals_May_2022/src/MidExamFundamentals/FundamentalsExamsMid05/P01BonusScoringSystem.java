package MidExamFundamentals.FundamentalsExamsMid05;

import java.util.Scanner;

public class P01BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int students = Integer.parseInt(scanner.nextLine());
        int lectures = Integer.parseInt(scanner.nextLine());
        int additionalBonus = Integer.parseInt(scanner.nextLine());

        double maxBonus =Double.MIN_VALUE;
        int maxAttendance = Integer.MIN_VALUE;
        double totalBonus = 0;

        if(students==0||lectures==0){
            System.out.println("Max Bonus: 0.");
            System.out.println("The student has attended 0 lectures.");
        }else {
            for (int i = 0; i < students; i++) {
                int attendanceStudents = Integer.parseInt(scanner.nextLine());

                totalBonus = (attendanceStudents * 1.00 / lectures) * (5 + additionalBonus);

                if (totalBonus > maxBonus) {
                    maxBonus = totalBonus;
                    maxAttendance = attendanceStudents;
                }
            }
            System.out.printf("Max Bonus: %d.%n", Math.round(maxBonus));
            System.out.printf("The student has attended %d lectures.", maxAttendance);
        }
    }
}
