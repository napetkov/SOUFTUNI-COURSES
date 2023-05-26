package DataTypesAndVariables.Exercises;

import java.util.Scanner;

public class P07WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numbersOfLines = Integer.parseInt(scanner.nextLine());
        int remainingVolume = 255;
        for (int i = 0; i < numbersOfLines; i++) {
            int quantityOfWater = Integer.parseInt(scanner.nextLine());
            if(quantityOfWater<=remainingVolume){
                remainingVolume -=quantityOfWater;
            }else{
                System.out.println("Insufficient capacity!");
            }
        }
        System.out.println(255-remainingVolume);

    }
}
