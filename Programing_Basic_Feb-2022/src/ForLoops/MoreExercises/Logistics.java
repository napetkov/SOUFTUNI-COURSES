package ForLoops.MoreExercises;

import java.util.Scanner;

public class Logistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int counterGoods = Integer.parseInt(scanner.nextLine());
        double sumTonnage = 0;
        int microBuss = 0;
        int truck = 0;
        int train = 0;
        double totalSum = 0;
        for (int i = 0; i < counterGoods; i++) {
            int tonnage = Integer.parseInt(scanner.nextLine());
            totalSum += tonnage;
            if (tonnage <= 3) {
                microBuss += tonnage;
            } else if (tonnage <= 11) {
                truck += tonnage;
            } else {
                train += tonnage;
            }
        }
        double averagePrice = (microBuss * 200 + truck * 175 + train * 120) / totalSum;
        System.out.printf("%.2f%n",averagePrice);
        System.out.printf("%.2f%%%n",microBuss/totalSum*100);
        System.out.printf("%.2f%%%n",truck/totalSum*100);
        System.out.printf("%.2f%%%n",train/totalSum*100);

    }
}
