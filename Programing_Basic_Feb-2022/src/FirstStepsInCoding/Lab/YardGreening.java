package FirstStepsInCoding.Lab;

import java.util.Scanner;

public class YardGreening {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        //Прочитане на вход
        double area = Double.parseDouble(scanner.nextLine());
        //Изчисления
        double priceWhitoutDiscount = area * 7.61;
        double discount = priceWhitoutDiscount * 0.18;
        double finalPrice = priceWhitoutDiscount - discount;
        System.out.printf("The final price is: %f lv.",finalPrice);
        System.out.println();
        System.out.printf("The discount is: %f lv.",discount);



        //Принт
    }
}
