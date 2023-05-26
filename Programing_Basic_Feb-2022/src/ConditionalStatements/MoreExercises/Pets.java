package ConditionalStatements.MoreExercises;

import java.util.Scanner;

public class Pets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        int foodKg = Integer.parseInt(scanner.nextLine());
        double foodDogForDay = Double.parseDouble(scanner.nextLine());
        double foodCatForDay = Double.parseDouble(scanner.nextLine());
        double foodTurtleForDay = Double.parseDouble(scanner.nextLine());
        //foodTurtleForDay = foodTurtleForDay / 1000;
        double foodNeeded = foodDogForDay * days + foodCatForDay * days + (foodTurtleForDay * days)/1000;
        if (foodKg>=foodNeeded) {
           //закръгляме надолу защото е остатък??? - чети УСЛОВИЯТА!!!
            System.out.printf("%.0f kilos of food left.", Math.floor(foodKg-foodNeeded));
        } else {
            //закръгляме нагоре защото е недостиг??? - чети УСЛОВИЯТА!!!
            System.out.printf("%.0f more kilos of food are needed.", Math.ceil(foodNeeded - foodKg));
        }


    }
}
