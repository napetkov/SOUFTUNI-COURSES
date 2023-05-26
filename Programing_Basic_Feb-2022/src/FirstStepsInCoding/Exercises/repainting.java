package FirstStepsInCoding.Exercises;

import java.util.Scanner;

public class repainting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //найлон - 1,5/кв
        //боя 14,50/л
        //разредител 5/л
        //+10%боя
        //+2кв найлон
        //0,4торбички
        //майстор 1ч. = всикчко*30%
        int plastic = Integer.parseInt(scanner.nextLine());
        int paint = Integer.parseInt(scanner.nextLine());
        int thinner = Integer.parseInt(scanner.nextLine());
        int painterNeededHouers = Integer.parseInt(scanner.nextLine());
        double priceMaterials = (plastic+2)*1.5 + paint*14.5*1.1 + thinner*5 + 0.4;
        double finalPrice = priceMaterials*0.3*painterNeededHouers+priceMaterials;
        System.out.println(finalPrice);



    }
}
