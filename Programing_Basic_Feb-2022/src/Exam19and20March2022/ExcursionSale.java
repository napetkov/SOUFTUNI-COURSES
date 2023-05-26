package Exam19and20March2022;

import java.util.Scanner;

public class ExcursionSale {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int excursionSea = Integer.parseInt(scanner.nextLine());
        int excursionMountain = Integer.parseInt(scanner.nextLine());
        int priceSea = 680;
        int priceMountain = 499;
        String input = scanner.nextLine();
        int profit = 0;
        while (!input.equals("Stop")) {
            switch ((input)) {
                case "sea":
                    if(excursionSea<=0){
                        input= scanner.nextLine();
                        continue;
                    }
                    excursionSea -= 1;
                    profit += 680;
                    break;
                case "mountain":
                    if(excursionMountain<=0){
                        input= scanner.nextLine();
                        continue;
                    }
                    excursionMountain -= 1;
                    profit += 499;
                    break;
            }
            if (excursionMountain <= 0 && excursionSea <= 0) {
                System.out.println("Good job! Everything is sold.");
                break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Profit: %d leva.", profit);

    }
}
