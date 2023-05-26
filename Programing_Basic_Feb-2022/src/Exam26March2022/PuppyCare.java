package Exam26March2022;

import java.util.Scanner;

public class PuppyCare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int boughtFood = Integer.parseInt(scanner.nextLine());
        boughtFood = boughtFood*1000;
        String input = scanner.nextLine();
        int totalFood = 0;
        while(!input.equals("Adopted")){
            int eatenFood = Integer.parseInt(input);
            totalFood+=eatenFood;

            input = scanner.nextLine();
        }
        if(totalFood>boughtFood){
            System.out.printf("Food is not enough. You need %d grams more.",totalFood-boughtFood);
        }else{
            System.out.printf("Food is enough! Leftovers: %d grams.",boughtFood-totalFood);
        }


    }
}
