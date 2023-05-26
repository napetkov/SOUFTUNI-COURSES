package Methods.Lab;

import java.util.Scanner;

public class P05Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String products = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());
        double priceOfProduct = 0;
        switch (products) {
            case "coffee":
                priceOfProduct = 1.50;
                break;
            case "water":
                priceOfProduct = 1.00;
                break;
            case "coke":
                priceOfProduct = 1.40;
                break;
            case "snacks":
                priceOfProduct = 2.00;
                break;
        }
        System.out.printf("%.2f",totalPrice(quantity,priceOfProduct));

    }
    public static double totalPrice(int quantity,double priceOfProduct){
        return quantity*priceOfProduct;
    }
}
