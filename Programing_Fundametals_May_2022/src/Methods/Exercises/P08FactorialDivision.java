package Methods.Exercises;

import java.text.DecimalFormat;
import java.util.Scanner;

public class P08FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int first = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());


        System.out.printf("%.2f", (firstFactorials(first) / secondFactorials(second)));

    }

    public static double firstFactorials(int first) {
        long firstFac = 1;
        if (first < 2 && first > -2) {
            return first;
        } else if(first>=2){
            for (int i = 2; i <= first; i++) {
                firstFac = firstFac * i;

            }
        }else if(first<=-2){
            for (int i = first; i <=-2 ; i++) {
                firstFac = firstFac * i;
            }
        }
        return firstFac;
    }

    public static double secondFactorials(int second) {
        long secondFac = 1;
        if (second < 2&&second>-2) {
            return second;
        } else if(second>=2){
            for (int i = 2; i <= second; i++) {
                secondFac = secondFac * i;
            }
        }else if(second<=-2){
            for (int i = second; i <=-2 ; i++) {
                secondFac = secondFac * i;
            }
        }
        return secondFac;
    }
}
