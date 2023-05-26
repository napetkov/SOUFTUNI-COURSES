package FirstStepsInCoding.Exercises;

import java.util.Scanner;

public class vacationBooksList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pages = Integer.parseInt(scanner.nextLine());
        int pagesForOneHouer = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());
        //Изчисления:
        int resultDays = pages/pagesForOneHouer/days;
        System.out.println(resultDays);

    }
}
