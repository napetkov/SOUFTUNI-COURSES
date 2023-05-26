package OtherPractis;

import java.util.Scanner;

public class NameGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int maxPoints = Integer.MIN_VALUE;
        String maxName = "";
        while (!input.equals("Stop")) {
            int sumPoints = 0;
            for (int i = 0; i < input.length(); i++) {
                int number = Integer.parseInt(scanner.nextLine());
                if(number == input.charAt(i)){
                    sumPoints +=10;
                }else{
                    sumPoints +=2;
                }

            }
            if(sumPoints>=maxPoints){
                maxPoints = sumPoints;
                maxName = input;
            }
            input = scanner.nextLine();
        }
        System.out.printf("The winner is %s with %d points!",maxName,maxPoints);


    }
}
