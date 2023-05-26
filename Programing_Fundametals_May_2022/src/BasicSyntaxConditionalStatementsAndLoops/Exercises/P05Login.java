package BasicSyntaxConditionalStatementsAndLoops.Exercises;

import java.util.Scanner;

public class P05Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        int length = username.length();
        String revers = "";
        for (int i = length-1; 0 <= i; i--) {
            revers += username.charAt(i);
        }
        int counter = 0;
        boolean flag = true;
        String password = scanner.nextLine();

        while(!password.equals(revers)){
            counter++;
            if(counter==4){
                System.out.printf("User %s blocked!",username);
                break;
            }
            System.out.println("Incorrect password. Try again.");
            flag = false;
            password = scanner.nextLine();
        }

     if(revers.equals(password)){
         System.out.printf("User %s logged in.",username);
     }

    }
}
