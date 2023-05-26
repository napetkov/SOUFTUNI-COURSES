package ExamsPractis.Exam15and16June2019;

import java.util.Scanner;

public class FavoriteMovie {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String movieName = "";
        int counter = 1;
        int maxSUm = Integer.MIN_VALUE;
        boolean flag = true;
        while (!input.equals("STOP")) {
            if(counter==7){
                System.out.printf("The limit is reached.%n");
                flag = false;
                break;
            }
            int sum = 0;
            for (int i = 0; i < input.length(); i++) {
                int asciiNum = input.charAt(i);
                if (asciiNum >= 65 && asciiNum <= 90) {
                    asciiNum -= input.length();
                } else if (asciiNum >= 97 && asciiNum <= 122) {
                    asciiNum -= input.length() * 2;
                }
                sum += asciiNum;
            }
            if(maxSUm<sum){
                maxSUm = sum;
                movieName = input;
            }
            input = scanner.nextLine();
            counter++;
        }
          System.out.printf("The best movie for you is %s with %d ASCII sum.",movieName,maxSUm);



    }
}
