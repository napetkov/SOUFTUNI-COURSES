package ForLoops.MoreExercises;

import java.util.Scanner;

public class Bills {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int months = Integer.parseInt(scanner.nextLine());
        int water = months*20;
        int internet = months*15;
        double electricity = 0;
        for (int i = 0; i < months; i++) {
            double electricityForOneMonth = Double.parseDouble(scanner.nextLine());
            electricity += electricityForOneMonth;
        }
        double other = (water+internet+electricity)*1.20;
        double totalBills = electricity+water+internet+other;
        System.out.printf("Electricity: %.2f lv%n",electricity);
        System.out.printf("Water: %.2f lv%n",water*1.00);
        System.out.printf("Internet: %.2f lv%n",internet*1.00);
        System.out.printf("Other: %.2f lv%n",other);
        System.out.printf("Average: %.2f lv",totalBills/months);


    }
}
