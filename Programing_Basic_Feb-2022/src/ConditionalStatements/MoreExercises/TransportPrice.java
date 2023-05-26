package ConditionalStatements.MoreExercises;

import java.util.Scanner;

public class TransportPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String dayTime = scanner.nextLine();
        double priceTrip = 0;
        //•	Такси. Начална такса: 0.70 лв. Дневна тарифа: 0.79 лв. / км. Нощна тарифа: 0.90 лв. / км.
        //•	Автобус. Дневна / нощна тарифа: 0.09 лв. / км. Може да се използва за разстояния минимум 20 км.
        //•	Влак. Дневна / нощна тарифа: 0.06 лв. / км. Може да се използва за разстояния минимум 100 км.
        if (n >= 100) {
            priceTrip = n * 0.06;
            System.out.printf("%.2f",priceTrip);
        } else if (n >= 20) {
            priceTrip = n * 0.09;
            System.out.printf("%.2f",priceTrip);
        } else if (dayTime.equals("day")) {
            priceTrip = 0.7 + (n * 0.79);
            System.out.printf("%.2f",priceTrip);
        } else {
            priceTrip = 0.7 + (n * 0.9);
            System.out.printf("%.2f",priceTrip);
        }


    }
}
