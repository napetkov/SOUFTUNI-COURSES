package DataTypesAndVariables.Exercises;

import java.util.Scanner;

public class P08BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        double maxVolume = Integer.MIN_VALUE;
        String maxModel = "";
        for (int i = 0; i < n; i++) {
            double volume = 0;

            String modelKeg = scanner.nextLine();
            double radiusKeg = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());

            volume = Math.PI * Math.pow(radiusKeg, 2) * height;
            if(volume>=maxVolume){
                maxVolume=volume;
                maxModel=modelKeg;
            }
        }
        System.out.print(maxModel);

    }
}
