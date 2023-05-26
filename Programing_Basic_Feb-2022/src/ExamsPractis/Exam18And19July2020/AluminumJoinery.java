package ExamsPractis.Exam18And19July2020;

import java.util.Scanner;

public class AluminumJoinery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int joineryNum = Integer.parseInt(scanner.nextLine());
        String type = scanner.nextLine();
        String delivery = scanner.nextLine();
        double price = 0;
        double totalPrice = 0;
        switch (type) {
            case "90X130":
                price = 110;
                if (joineryNum >= 30 && joineryNum < 60) {
                    price = price - price * 0.05;
                } else if (joineryNum >= 60) {
                    price = price - price * 0.08;
                }
                break;
            case "100X150":
                price = 140;
                if (joineryNum >= 40 && joineryNum < 80) {
                    price = price - price * 0.06;
                } else if (joineryNum >= 80) {
                    price = price - price * 0.10;
                }
                break;
            case "130X180":
                price = 190;
                if (joineryNum >= 20 && joineryNum < 50) {
                    price = price - price * 0.07;
                } else if (joineryNum >= 50) {
                    price = price - price * 0.12;
                }
                break;
            case "200X300":
                price = 250;
                if (joineryNum >= 25 && joineryNum < 50) {
                    price = price - price * 0.09;
                } else if (joineryNum >= 50) {
                    price = price - price * 0.14;
                }
                break;
        }
        totalPrice = price * joineryNum;
        if (delivery.equals("With delivery")) {
            totalPrice = totalPrice + 60;
        }
        if (joineryNum < 10) {
            System.out.println("Invalid order");
        } else if (joineryNum >= 100) {
            totalPrice = totalPrice - totalPrice * 0.04;
            System.out.printf("%.2f BGN", totalPrice);
        }else{

            System.out.printf("%.2f BGN", totalPrice);
        }

    }
}
