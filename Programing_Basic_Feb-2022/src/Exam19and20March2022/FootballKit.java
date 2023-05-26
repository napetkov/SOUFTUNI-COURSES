package Exam19and20March2022;

import java.util.Scanner;

public class FootballKit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double priceTShirt = Double.parseDouble(scanner.nextLine());
        double sumForBonus = Double.parseDouble(scanner.nextLine());

        double shorts = priceTShirt*0.75;
        double socks = shorts*0.20;
        double footballButtons = 2*(priceTShirt+shorts);
        double totalSum = priceTShirt+shorts+socks+footballButtons;
        totalSum = totalSum*0.85;
        if(totalSum>=sumForBonus){
            System.out.println("Yes, he will earn the world-cup replica ball!");
            System.out.printf("His sum is %.2f lv.",totalSum);
        }else{
            System.out.println("No, he will not earn the world-cup replica ball.");
            System.out.printf("He needs %.2f lv. more.",sumForBonus-totalSum);
        }




    }
}
