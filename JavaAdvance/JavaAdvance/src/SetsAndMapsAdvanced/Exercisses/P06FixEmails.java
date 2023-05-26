package SetsAndMapsAdvanced.Exercisses;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class P06FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputName = scanner.nextLine();

        Map<String,String> emailBook = new LinkedHashMap<>();

        while(!inputName.equals("stop")){
            String email = scanner.nextLine();


            String sublist = email.substring((email.length()-3), email.length());
            if(!sublist.equals(".uk")&&!sublist.equals(".us")&&!sublist.equals("com")){
                emailBook.put(inputName,email);
            }


            inputName = scanner.nextLine();
        }

        emailBook.forEach((k,v)->{
            System.out.printf("%s -> %s%n",k,v);
        });
    }
}
