package ConditionalStatements.MoreExercises;

import java.util.Scanner;

public class Firm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int neededHours = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());
        int employers = Integer.parseInt(scanner.nextLine());
        double resultHours = (days*0.9)*8 + (employers*2)*days;
        resultHours = Math.floor(resultHours);

        if(neededHours<=resultHours){
            System.out.printf("Yes!%.0f hours left.",(resultHours-neededHours));
        }else{
            System.out.printf("Not enough time!%.0f hours needed.",(neededHours-resultHours));
        }



    }
}
