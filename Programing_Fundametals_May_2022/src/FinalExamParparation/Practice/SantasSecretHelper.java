package FinalExamParparation.Practice;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SantasSecretHelper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();
        List<String> goodChildren = new ArrayList<>();

        while (!input.equals("end")) {
            StringBuilder encryptedMassage = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                char symbol = (char) (input.charAt(i) - n);
                encryptedMassage.append(symbol);
            }

            Pattern pattern = Pattern.compile("@(?<name>[A-Za-z]+)[^@!:>\\-]+!(?<behavior>[G,N])!");
            Matcher matcher = pattern.matcher(encryptedMassage);

            if(matcher.find()){
                String name = matcher.group("name");
                String behavior = matcher.group("behavior");
                if(behavior.equals("G")){
                 goodChildren.add(name);
                }
            }

            input = scanner.nextLine();
        }
       goodChildren.forEach(element->{
           System.out.println(element);
       });
    }
}
