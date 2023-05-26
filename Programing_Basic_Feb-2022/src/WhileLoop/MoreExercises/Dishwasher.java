package WhileLoop.MoreExercises;

import java.util.Scanner;

public class Dishwasher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bottles = Integer.parseInt(scanner.nextLine());
        int detergent = bottles * 750;
        String input = scanner.nextLine();
        int count = 0;
        int countDishes = 0;
        int countPots = 0;
        boolean isEnough = true;
        while (!input.equals("End")) {
            count++;
            if (count % 3 != 0) {
                int dishes = Integer.parseInt(input);
                countDishes += dishes;
                detergent -= dishes * 5;
            } else {
                int pots = Integer.parseInt(input);
                countPots += pots;
                detergent -= pots * 15;
            }
            if (detergent < 0) {
                isEnough = false;
                break;
            }
            input = scanner.nextLine();
        }
        if(isEnough){
            System.out.println("Detergent was enough!");
            System.out.printf("%d dishes and %d pots were washed.%n",countDishes,countPots);
            System.out.printf("Leftover detergent %d ml.",detergent);
        }else{
            System.out.printf("Not enough detergent, %d ml. more necessary!",Math.abs(detergent));
        }

    }
}
