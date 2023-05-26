package BasicSyntaxConditionalStatementsAndLoops.Lab;

import java.util.Scanner;

public class P04BackIn30Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hours = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());
        int allNewMinutes = hours * 60 + minutes + 30;
        hours = allNewMinutes / 60;
        if (hours == 24) {
            hours = 0;
        }
        minutes = allNewMinutes % 60;
        System.out.printf("%d:%02d", hours, minutes);


    }
}
