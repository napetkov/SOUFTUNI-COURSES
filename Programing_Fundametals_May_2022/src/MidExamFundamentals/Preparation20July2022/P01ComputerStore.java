package MidExamFundamentals.Preparation20July2022;

import java.util.Scanner;

public class P01ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double priceWithoutTax = 0;

        while ((!input.equals("special"))&&(!input.equals("regular"))) {
            double partsPrice = Double.parseDouble(input);
            if (partsPrice < 0) {
                System.out.println("Invalid price!");
            } else {
                priceWithoutTax += partsPrice;
            }
            input = scanner.nextLine();
        }
        if (priceWithoutTax == 0) {
            System.out.println("Invalid order!");
        } else {
            System.out.printf("Congratulations you've just bought a new computer!%n" +
                    "Price without taxes: %.2f$%n", priceWithoutTax);
            double taxes = priceWithoutTax * 0.2;
            System.out.printf("Taxes: %.2f$%n",taxes);
            System.out.println("-----------");
            double priceWhitTaxes = (priceWithoutTax+taxes);
            if(input.equals("special")){
                priceWhitTaxes = priceWhitTaxes*0.90;
            }
            System.out.printf("Total price: %.2f$",priceWhitTaxes);
        }


    }
}
