package Methods.Exercises;

import java.util.Scanner;

public class P05AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstInt = Integer.parseInt(scanner.nextLine());
        int secondInt = Integer.parseInt(scanner.nextLine());
        int thirdInt = Integer.parseInt(scanner.nextLine());

        System.out.println(subtract(sum(firstInt,secondInt),thirdInt));

    }

    public static int sum(int firstInt,int secondInt){
        return firstInt+secondInt;
    }
    public static int subtract(int sum,int thirdInt){
        return sum-thirdInt;
    }
}
