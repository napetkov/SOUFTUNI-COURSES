package ExamsPractis.Exam18And19July2020;

import java.util.Scanner;

public class BestPlayer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String namePlayer = scanner.nextLine();
        String bestPlayer = "";
        int maxGoals = 0;
        while (!namePlayer.equals("END")) {
            int goals = Integer.parseInt(scanner.nextLine());
            if (maxGoals < goals) {
                maxGoals = goals;
                bestPlayer = namePlayer;
            }
            if(maxGoals>=10){
                break;
            }
            namePlayer = scanner.nextLine();
        }
        System.out.printf("%s is the best player!%n",bestPlayer);
        if(maxGoals>=3){
            System.out.printf("He has scored %d goals and made a hat-trick !!!",maxGoals);
        }else{
            System.out.printf("He has scored %d goals.",maxGoals);
        }

    }
}
