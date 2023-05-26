package ConditionalStatementsAdvanced.MoreExercises;

import java.util.Scanner;

public class MatchTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        String category = scanner.nextLine();
        int person = Integer.parseInt(scanner.nextLine());
        double ticketBudget = 0;
        double ticketPrice = 0;
        switch (category) {
            case "VIP":
                ticketPrice = 499.99;
                break;
            case "Normal":
                ticketPrice = 249.99;
                break;
        }
        if (person >= 1 && person <= 4) {
            ticketBudget = budget * (1-0.75);
        } else if (person > 4 && person <= 9) {
            ticketBudget = budget *(1-0.60);
        } else if (person > 9 && person <= 24) {
            ticketBudget = budget * (1-0.50);
        } else if (person > 24 && person <= 49) {
            ticketBudget = budget * (1-0.40);
        } else {
            ticketBudget = budget * (1-0.25);
        }
        if((ticketPrice*person)<=ticketBudget){
            System.out.printf("Yes! You have %.2f leva left.",(ticketBudget-ticketPrice*person));
        }else{
            System.out.printf("Not enough money! You need %.2f leva.",Math.abs(ticketBudget-ticketPrice*person));
        }

    }
}
