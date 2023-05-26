package ExamsPractis.Exam28And29March2020;

import java.util.Scanner;

public class EnergyBooster {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fruit = scanner.nextLine();
        String size = scanner.nextLine();
        int sets = Integer.parseInt(scanner.nextLine());
        double price = 0;
        double totalPrice = 0;
        switch (fruit) {
            case "Watermelon":
                if (size.equals("small")) {
                    price = 56;
                    totalPrice = price * 2;
                } else if (size.equals("big")) {
                    price = 28.70;
                    totalPrice = price * 5;
                }
                break;
            case "Mango":
                if (size.equals("small")) {
                    price = 36.66;
                    totalPrice = price * 2;
                } else if (size.equals("big")) {
                    price = 19.60;
                    totalPrice = price * 5;
                }
                break;
            case "Pineapple":
                if (size.equals("small")) {
                    price = 42.10;
                    totalPrice = price * 2;
                } else if (size.equals("big")) {
                    price = 24.80;
                    totalPrice = price * 5;
                }
                break;
            case "Raspberry":
                if (size.equals("small")) {
                    price = 20.00;
                    totalPrice = price * 2;
                } else if (size.equals("big")) {
                    price = 15.20;
                    totalPrice = price * 5;
                }
                break;
        }
        totalPrice = totalPrice * sets;
if(totalPrice>=400&&totalPrice<=1000){
    totalPrice = totalPrice-totalPrice*0.15;
}else if(totalPrice>1000){
    totalPrice=totalPrice-totalPrice*0.50;
}
        System.out.printf("%.2f lv.",totalPrice);
    }
}
