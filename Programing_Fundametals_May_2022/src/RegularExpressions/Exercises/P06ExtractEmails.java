package RegularExpressions.Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P06ExtractEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        //Pattern pattern = Pattern.compile("\\b\\w+[.|_|-]?\\w+@\\w+-?\\w+.?\\w+\\.\\w+\\b");
        //Regex Desi
        Pattern pattern = Pattern.compile("[A-Za-z0-9]+[._-]?[A-Za-z0-9]+@[A-Za-z]+-?[A-Za-z]+(\\.[A-Za-z]+-?[A-Za-z])+");
        Matcher matcher = pattern.matcher(input);

        List<String> emailList = new ArrayList<>();
        //Деси - може да се печата директно в цикъла не е нобходим лист за по бърза работа.
        //Помисли Николай,недей спа...
        while (matcher.find()) {
            emailList.add(matcher.group());
        }
        emailList.forEach(element -> System.out.println(element));

    }
}
