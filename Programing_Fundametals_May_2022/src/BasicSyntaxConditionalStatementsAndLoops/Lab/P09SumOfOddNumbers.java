package BasicSyntaxConditionalStatementsAndLoops.Lab;

import java.util.Scanner;

public class P09SumOfOddNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOdds = Integer.parseInt(scanner.nextLine());
        int numIteration = 1;
        int sumOdds = 0;
        for (int i = 1; i <= numOdds * 2; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
                sumOdds += i;
            }

        }


//        for (int i = 0; i <=100 ; i++) {
//            if(i%2!=0){
//                System.out.println(i);
//                sumOdds +=i;
//                numIteration++;
//            }
//            if(numIteration>numOdds){
//                break;
//            }
//        }

        System.out.printf("Sum: %d", sumOdds);
    }
}
