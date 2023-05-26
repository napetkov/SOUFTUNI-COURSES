package ConditionalStatements.Exercises;

import java.util.Scanner;

public class Shopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budgetPetter = Double.parseDouble(scanner.nextLine());
        int videoCards = Integer.parseInt(scanner.nextLine());
        int processor = Integer.parseInt(scanner.nextLine());
        int ram = Integer.parseInt(scanner.nextLine());
        //•	Видеокарта – 250 лв./бр.
        //•	Процесор – 35% от цената на закупените видеокарти/бр.
        //•	Рам памет – 10% от цената на закупените видеокарти/бр.

        int videoCardsPrice = videoCards * 250;
        double processorPrice = videoCardsPrice * 0.35;
        double ramPrice = videoCardsPrice * 0.1;
        double sum = videoCardsPrice + processor * processorPrice + ram * ramPrice;

             if (videoCards > processor) {
            sum = sum - sum * 0.15;
        }
            double difference = Math.abs(budgetPetter - sum);

             if (budgetPetter < sum){
                 System.out.printf("Not enough money! You need %.2f leva more!",difference);
             }else {
                 System.out.printf ("You have %.2f leva left!",difference);
             }

    }

}
