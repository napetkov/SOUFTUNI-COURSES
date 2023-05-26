package FinalExam07Aug2022;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EncryptingPassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();

            Pattern validPassword = Pattern.compile("(.+)>(?<numbers>[0-9]{3})\\|(?<lowerCase>[a-z]{3})\\|(?<upperCase>[A-Z]{3})\\|(?<symbols>[^<>]{3})<\\1");
            Matcher matchPassword = validPassword.matcher(input);

            if(matchPassword.find()){
            StringBuilder password = new StringBuilder();
            password.append(matchPassword.group("numbers"));
            password.append(matchPassword.group("lowerCase"));
            password.append(matchPassword.group("upperCase"));
            password.append(matchPassword.group("symbols"));

                System.out.println("Password: "+password.toString());


            }else{
                System.out.println("Try another password!");
            }

        }




    }
}
