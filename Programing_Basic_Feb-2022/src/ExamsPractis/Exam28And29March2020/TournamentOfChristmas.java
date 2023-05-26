package ExamsPractis.Exam28And29March2020;

import java.util.Scanner;

public class TournamentOfChristmas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        double sumForDay = 0;
        double totalMoney = 0;
        int countWin = 0;
        int countLose = 0;
        int countWinDays = 0;

        for (int i = 1; i <= days; i++) {
            String input = scanner.nextLine();
            sumForDay = 0;
            countWin = 0;
            countLose = 0;
            while (!input.equals("Finish")) {
                String result = scanner.nextLine();
                switch (result) {
                    case "win":
                        countWin++;
                        sumForDay += 20;
                        break;
                    case "lose":
                        countLose++;
                        break;
                }
                input = scanner.nextLine();
            }
            if (countWin > countLose) {
                sumForDay = sumForDay * 1.10;
                countWinDays++;
            }
            totalMoney += sumForDay;
        }
        if (countWinDays > days / 2) {
            totalMoney = totalMoney * 1.20;
            System.out.printf("You won the tournament! Total raised money: %.2f", totalMoney);
        } else {
            System.out.printf("You lost the tournament! Total raised money: %.2f", totalMoney);
        }
    }
}
