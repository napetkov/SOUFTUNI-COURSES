package ConditionalStatementsAdvanced.Lab;

import java.util.Scanner;

public class TradeCommissions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String city = scanner.nextLine();
        double sales = Double.parseDouble(scanner.nextLine());
        double commissions = 0;
        double result = 0;
        if (sales >= 0) {
            switch (city) {
                case "Sofia":
                    if (sales >= 0 && sales <= 500) {
                        commissions = 0.05;
                    } else if (sales > 500 && sales <= 1000) {
                        commissions = 0.07;
                    } else if (sales > 1000 && sales <= 10000) {
                        commissions = 0.08;
                    } else if (sales > 10000) {
                        commissions = 0.12;
                    }
                    result = sales * commissions;
                    System.out.printf("%.2f", result);
                    break;
                case "Varna":
                    if (sales >= 0 && sales <= 500) {
                        commissions = 0.045;
                    } else if (sales > 500 && sales <= 1000) {
                        commissions = 0.075;
                    } else if (sales > 1000 && sales <= 10000) {
                        commissions = 0.10;
                    } else if (sales > 10000) {
                        commissions = 0.13;
                    }
                    result = sales * commissions;
                    System.out.printf("%.2f", result);
                    break;
                case "Plovdiv":
                    if (sales >= 0 && sales <= 500) {
                        commissions = 0.055;
                    } else if (sales > 500 && sales <= 1000) {
                        commissions = 0.08;
                    } else if (sales > 1000 && sales <= 10000) {
                        commissions = 0.12;
                    } else if (sales > 10000) {
                        commissions = 0.145;
                    }
                    result = sales * commissions;
                    System.out.printf("%.2f", result);
                    break;
                default:
                    System.out.println("error");
                    break;
            }

        } else {
            System.out.println("error");
        }
    }
}
