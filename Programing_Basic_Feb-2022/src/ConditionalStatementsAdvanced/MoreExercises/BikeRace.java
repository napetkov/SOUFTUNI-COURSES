package ConditionalStatementsAdvanced.MoreExercises;

import java.util.Scanner;

public class BikeRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int juniors = Integer.parseInt(scanner.nextLine());
        int seniors = Integer.parseInt(scanner.nextLine());
        String trace = scanner.nextLine();
        double taxJuniors = 0;
        double taxSeniors = 0;
        switch (trace) {
            case "trail":
                taxJuniors = 5.50;
                taxSeniors = 7.00;
                break;
            case "cross-country":
                taxJuniors = 8;
                taxSeniors = 9.50;
                if ((juniors+seniors)>=50){
                    taxJuniors = taxJuniors*0.75;
                    taxSeniors = taxSeniors*0.75;
                }
                break;
            case "downhill":
                taxJuniors = 12.25;
                taxSeniors = 13.75;
                break;
            case "road":
                taxJuniors = 20.00;
                taxSeniors = 21.50;
                break;
        }
        System.out.printf("%.2f",(taxJuniors*juniors+taxSeniors*seniors)*0.95);

    }
}
