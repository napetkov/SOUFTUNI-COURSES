package ConditionalStatementsAdvanced.Lab;

import java.util.Scanner;

public class CinemaTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String day = scanner.nextLine();
        int ticketPrice = 0;
        if (day.equals("Monday") || day.equals("Tuesday") || day.equals("Friday")) {
            ticketPrice = 12;
        } else if (day.equals("Wednesday") || day.equals("Thursday")) {
            ticketPrice = 14;
        } else if (day.equals("Sunday") || day.equals("Saturday")) {
            ticketPrice = 16;
        }
        System.out.println(ticketPrice);
    }

}
