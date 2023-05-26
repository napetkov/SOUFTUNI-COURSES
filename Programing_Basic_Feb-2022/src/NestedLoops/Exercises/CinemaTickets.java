package NestedLoops.Exercises;

import java.util.Scanner;

public class CinemaTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nameMovies = scanner.nextLine();
        int totalTickets = 0;
        int sumStandard = 0;
        int sumStudent = 0;
        int sumKid = 0;
        while (!nameMovies.equals("Finish")) {
            int freeSeats = Integer.parseInt(scanner.nextLine());
            String ticketType = scanner.nextLine();
            int countTicket = 0;
            while (!ticketType.equals("End")) {
                totalTickets++;
                countTicket++;
                switch (ticketType) {
                    case "standard":
                        sumStandard++;
                        break;
                    case "student":
                        sumStudent++;
                        break;
                    case "kid":
                        sumKid++;
                        break;
                }
                if (countTicket == freeSeats) {
                    break;
                }

                ticketType = scanner.nextLine();
            }
            System.out.printf("%s - %.2f%% full.%n",nameMovies,countTicket*1.00/freeSeats*100);

            nameMovies = scanner.nextLine();
        }
        System.out.printf("Total tickets: %d%n",totalTickets);
        System.out.printf("%.2f%% student tickets.%n",sumStudent*1.00/totalTickets*100);
        System.out.printf("%.2f%% standard tickets.%n",sumStandard*1.00/totalTickets*100);
        System.out.printf("%.2f%% kids tickets.",sumKid*1.00/totalTickets*100);

    }
}
