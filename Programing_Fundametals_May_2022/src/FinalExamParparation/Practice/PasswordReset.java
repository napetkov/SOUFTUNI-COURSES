package FinalExamParparation.Practice;

import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rawPassword = scanner.nextLine();
        String input = scanner.nextLine();
        StringBuilder newPassword = new StringBuilder(rawPassword);

        while (!input.equals("Done")) {
            String command = input.split(" ")[0];

            switch (command) {
                case "TakeOdd":
                    String oddPassword = newPassword.toString();
                    newPassword = new StringBuilder();
                    for (int i = 0; i < oddPassword.length(); i++) {
                        if(i%2!=0){
                            newPassword.append(oddPassword.charAt(i));
                        }
                    }
                    System.out.println(newPassword.toString());
                    break;
                case "Cut":
                    int index = Integer.parseInt(input.split(" ")[1]);
                    int length = Integer.parseInt(input.split(" ")[2]);
                    newPassword.delete(index,index+length);
                    System.out.println(newPassword.toString());
                    break;
                case "Substitute":
                    String substring = input.split(" ")[1];
                    String substitute = input.split(" ")[2];
                    String subsPassword = newPassword.toString();
                    if(subsPassword.contains(substring)){
                       subsPassword = subsPassword.replace(substring,substitute);
                       newPassword = new StringBuilder(subsPassword);
                        System.out.println(newPassword.toString());
                    }else{
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println("Your password is: "+newPassword.toString());

    }
}
