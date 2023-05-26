package ExamsPractis.Exam28And29March2020;

import java.util.Scanner;

public class FoodForPets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        int allFood = Integer.parseInt(scanner.nextLine());
        double sumFoodDog = 0;
        double sumFoodCat = 0;
        double sumFood = 0;
        double sumFoodForDay = 0;
        int counter = 0;
        double biscuits = 0;
        for (int i = 0; i < days; i++) {
            counter++;
            int dogFood = Integer.parseInt(scanner.nextLine());
            int catFood = Integer.parseInt(scanner.nextLine());
            sumFoodDog +=dogFood;
            sumFoodCat += catFood;
            sumFoodForDay = dogFood+catFood;
            sumFood +=sumFoodForDay;
            if(counter%3==0){
                biscuits += sumFoodForDay*0.10;
            }
        }
        System.out.printf("Total eaten biscuits: %.0fgr.%n",biscuits);
        System.out.printf("%.2f%% of the food has been eaten.%n",sumFood/allFood*100);
        System.out.printf("%.2f%% eaten from the dog.%n",sumFoodDog/sumFood*100);
        System.out.printf("%.2f%% eaten from the cat.",sumFoodCat/sumFood*100);


    }
}
