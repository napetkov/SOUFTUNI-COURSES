package ConditionalStatements.Exercises;

import java.util.Scanner;

public class BonusScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int points = Integer.parseInt(scanner.nextLine());
        double bonusPoints = 0;
        double allPoints = 0;

        if (points <= 100) {
            bonusPoints = 5;
            allPoints = points + bonusPoints;

        } else if (points <= 1000) {
            bonusPoints = points * 0.2;
            allPoints = points + points * 0.2;

        } else if (points > 1000) {
            bonusPoints = points * 0.1;
            allPoints = points + bonusPoints;

        }
        if (points % 2 == 0) {
            bonusPoints = bonusPoints + 1;
            allPoints = points + bonusPoints;
        }else if(points % 10 == 5){
            bonusPoints = bonusPoints + 2;
            allPoints = points + bonusPoints;

        }
        System.out.println(bonusPoints);
        System.out.println(allPoints);
        //•	Ако числото е до 100 включително, бонус точките са 5.
        //•	Ако числото е по-голямо от 100, бонус точките са 20% от числото.
        //•	Ако числото е по-голямо от 1000, бонус точките са 10% от числото.
        //
        //•	Допълнителни бонус точки (начисляват се отделно от предходните):
        //o	За четно число  + 1 т.
        //o	За число, което завършва на 5  + 2 т.


    }
}
