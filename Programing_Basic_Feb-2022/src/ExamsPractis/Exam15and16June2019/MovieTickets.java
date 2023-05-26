package ExamsPractis.Exam15and16June2019;

import java.util.Scanner;

public class MovieTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a1 = Integer.parseInt(scanner.nextLine());
        int a2 = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = a1; i < a2; i++) {
            String symbol1 = Character.toString(i);
            //char symbol = (char)i;
            for (int j = 1; j <=(n-1) ; j++) {
                int symbol2 = j;
                for (int k = 1; k <=(n/2-1) ; k++) {
                    int symbol3 = k;
                    int symbol4 = i;
                    if(symbol4%2!=0&&(symbol2+symbol3+symbol4)%2!=0){
                        System.out.printf("%s-%d%d%d%n",symbol1,symbol2,symbol3,symbol4);
                    }
                }

            }
        }

    }
}
