package ForLoops.MoreExercises;

import java.util.Scanner;

public class EqualPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int maxDiff = Integer.MIN_VALUE;
        int sum3=0;
        int sum2=0;
        int sumValue = 0;
        int sumDiff = 0;
        for (int i = 0; i < (n); i++) {
            int n3 = Integer.parseInt(scanner.nextLine());
            int n4 = Integer.parseInt(scanner.nextLine());
            if(i==0){
                sum2 = n3+n4;
            }else if((n3+n4)==sum2){
                sumValue = sum2;
            }else {
                sum3 = sum2-(n3+n4);
                if(maxDiff<sum2-sum3){
                    maxDiff = sum3;
                }
            }
            sum2 = n3 + n4;
        }
      if(sumValue == sum2||n==1){
          System.out.printf("Yes, value=%d",sum2);
                }else{
          System.out.printf("No, maxdiff=%d",Math.abs(maxDiff));
      }
    }
}
