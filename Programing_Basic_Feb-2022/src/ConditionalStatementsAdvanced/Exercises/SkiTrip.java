package ConditionalStatementsAdvanced.Exercises;

import java.util.Scanner;

public class SkiTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        String room = scanner.nextLine();
        String rate = scanner.nextLine();

        double roomPrice = 0;
        switch (room) {
            case "room for one person":
                roomPrice = 18.00;
                break;
            case "apartment":
                roomPrice = 25.00;
                break;
            case "president apartment":
                roomPrice = 35.00;
                break;
        }
        if (days < 10) {
            switch (room) {
                case "apartment":
                    roomPrice = roomPrice * 0.70;
                    break;
                case "president apartment":
                    roomPrice = roomPrice * 0.90;
                    break;
            }

        } else if (days >= 10 && days <= 15) {
            switch (room) {
                case "apartment":
                    roomPrice = roomPrice * 0.65;
                    break;
                case "president apartment":
                    roomPrice = roomPrice * 0.85;
                    break;
            }

        } else {
            switch (room) {
                case "apartment":
                    roomPrice = roomPrice * 0.50;
                    break;
                case "president apartment":
                    roomPrice = roomPrice * 0.80;
                    break;
            }
        }
        switch (rate){
            case "positive":
                roomPrice = roomPrice*1.25;
                break;
            case "negative":
                roomPrice = roomPrice*0.9;
                break;
        }
        System.out.printf("%.2f",roomPrice*(days-1));

    }
}
