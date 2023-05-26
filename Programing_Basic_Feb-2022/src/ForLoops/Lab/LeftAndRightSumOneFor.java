package ForLoops.Lab;

import java.util.Scanner;

public class LeftAndRightSumOneFor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < n*2; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            if(i<n){
                leftSum += number;
            }else{
                rightSum+=number;
            }
        }



        if (leftSum == rightSum) {

            System.out.printf("Yes, sum = %d", leftSum);
        } else {
            System.out.printf("No, diff = %d", Math.abs(leftSum - rightSum));
        }

    }
}
