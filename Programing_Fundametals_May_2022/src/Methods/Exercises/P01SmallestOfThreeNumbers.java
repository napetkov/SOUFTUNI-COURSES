package Methods.Exercises;

import java.util.Scanner;

public class P01SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int first = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());
        int third = Integer.parseInt(scanner.nextLine());

        System.out.println(smallestNumber(first,second,third));


    }
    public static int smallestNumber(int first,int second,int third){
        int minInteger = Integer.MAX_VALUE;
        if(first<=second&&first<=third){
            minInteger = first;
        }else if(second<=third&&second<=first){
            minInteger = second;
        }else if(third<=first&&third<=second){
            minInteger = third;
        }

        return minInteger;
    }
}
