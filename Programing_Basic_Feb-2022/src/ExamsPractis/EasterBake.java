package ExamsPractis;

import java.util.Scanner;

public class EasterBake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int easternBread = Integer.parseInt(scanner.nextLine());
       double sumSugar = 0;
       double sumFlour = 0;
       int maxSugar = Integer.MIN_VALUE;
       int maxFlour = Integer.MIN_VALUE;
        for (int i = 0; i < easternBread; i++) {

            int sugar = Integer.parseInt(scanner.nextLine());
            int flour = Integer.parseInt(scanner.nextLine());
            sumSugar +=sugar;
            sumFlour +=flour;

            if(maxSugar<sugar){
                maxSugar = sugar;
            }
            if(maxFlour<flour){
                maxFlour = flour;
            }
        }
        System.out.printf("Sugar: %.0f%n",Math.ceil(sumSugar/950));
        System.out.printf("Flour: %.0f%n",Math.ceil(sumFlour/750));
        System.out.printf("Max used flour is %d grams, max used sugar is %d grams.",maxFlour,maxSugar   );

    }
}
