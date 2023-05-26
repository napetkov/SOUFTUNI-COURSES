package ExamsPractis.Exam28And29March2020;

import java.util.Scanner;

public class CatWalking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int minToWalk = Integer.parseInt(scanner.nextLine());
        int walks = Integer.parseInt(scanner.nextLine());
        int calCat = Integer.parseInt(scanner.nextLine());
        int totalCal = minToWalk*walks*5;
        if(totalCal>=(calCat/2)){
            System.out.printf("Yes, the walk for your cat is enough. Burned calories per day: %d.",totalCal);
        }else{
            System.out.printf("No, the walk for your cat is not enough. Burned calories per day: %d.",totalCal);
        }


    }
}
