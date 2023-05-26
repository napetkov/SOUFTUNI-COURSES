package ConditionalStatements.MoreExercises;

import java.util.Scanner;

public class FlowerShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //•	Магнолии – 3.25 лева
        //•	Зюмбюли – 4 лева
        //•	Рози – 3.50 лева
        //•	Кактуси – 8 лева

        int magnolias = Integer.parseInt(scanner.nextLine());
        int hyacinth = Integer.parseInt(scanner.nextLine());
        int roses = Integer.parseInt(scanner.nextLine());
        int cactus = Integer.parseInt(scanner.nextLine());
        double endPrice = Double.parseDouble(scanner.nextLine());
        double resultPrice = magnolias * 3.25 + hyacinth * 4 + roses * 3.5 + cactus * 8;
        resultPrice = resultPrice * 0.95;
        if(resultPrice>=endPrice){
            System.out.printf("She is left with %.0f leva.",Math.floor(resultPrice-endPrice));
        }else{
            System.out.printf("She will have to borrow %.0f leva.",Math.ceil(endPrice-resultPrice));
        }

    }
}
