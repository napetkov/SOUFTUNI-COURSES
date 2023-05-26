package ForLoops.MoreExercises;

import java.util.Scanner;

public class GameOIntervals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int moves = Integer.parseInt(scanner.nextLine());
        double totalSum = 0;
        double interval0To9 = 0;
        double interval10To19 = 0;
        double interval20To29 = 0;
        double interval30To39 = 0;
        double interval40To50 = 0;
        double invalidNumbers = 0;
        for (int i = 0; i < moves; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            if(number<0||number>50) {
                invalidNumbers++;
                totalSum = totalSum / 2;
            }else if (number <= 9) {
                interval0To9++;
                totalSum += number*0.2;
            } else if (number <= 19) {
                interval10To19++;
                totalSum += number * 0.3;
            } else if (number <= 29) {
                interval20To29++;
                totalSum += number * 0.4;
            } else if (number <= 39) {
                interval30To39++;
                totalSum += 50;
            } else  {
                interval40To50++;
                totalSum += 100;
            }

        }
        System.out.printf("%.2f%n",totalSum);
        System.out.printf("From 0 to 9: %.2f%%%n",interval0To9/moves*100);
        System.out.printf("From 10 to 19: %.2f%%%n",interval10To19/moves*100);
        System.out.printf("From 20 to 29: %.2f%%%n",interval20To29/moves*100);
        System.out.printf("From 30 to 39: %.2f%%%n",interval30To39/moves*100);
        System.out.printf("From 40 to 50: %.2f%%%n",interval40To50/moves*100);
        System.out.printf("Invalid numbers: %.2f%%",invalidNumbers/moves*100);



    }
}
