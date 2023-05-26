package ExamPerparation;

import java.util.Scanner;

public class TouristShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String input = scanner.nextLine();
        double needBudget = 0;
        int counter = 0;
        boolean flag = true;
        while (!input.equals("Stop")) {
            counter++;
        //    String nameProduct = scanner.nextLine();
            double priceProduct = Double.parseDouble(scanner.nextLine());

            if(counter%3==0){
                priceProduct = priceProduct/2;
            }
            needBudget += priceProduct;

            if (needBudget > budget) {
                System.out.println("You don't have enough money!");
                System.out.printf("You need %.2f leva!", needBudget - budget);
                flag = false;
                break;
            }
            input = scanner.nextLine();
        }
        if(flag){

            System.out.printf("You bought %d products for %.2f leva.",counter,needBudget);
        }

    }
}
