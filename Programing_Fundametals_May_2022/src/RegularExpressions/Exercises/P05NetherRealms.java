package RegularExpressions.Exercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P05NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] demonsArr = scanner.nextLine().split("\\s*,\\s*");

        for (String demon : demonsArr) {
            double baseDamage = demonsBaseDamage(demon);
            int health = demonsHealth(demon);

            System.out.printf("%s - %d health, %.2f damage%n",demon,health,baseDamage);


        }


    }

    private static int demonsHealth(String demon) {
        int health = 0;
        StringBuilder demonsName = new StringBuilder();

        Pattern letters = Pattern.compile("[^0-9*\\/. ,+\\-]");
        Matcher matchLetter = letters.matcher(demon);

        while(matchLetter.find()){
            char symbol = matchLetter.group().charAt(0);
            health += (char)symbol;
        }

        return health;
    }

    private static double demonsBaseDamage(String demon) {
        Pattern digits = Pattern.compile("[+-]?\\d+[\\.]?\\d*");
        Matcher matchDigit = digits.matcher(demon);
        Pattern multiDivide = Pattern.compile("[*\\/]");
        Matcher matchMultiDivide = multiDivide.matcher(demon);

        double baseDamage = 0;
        while (matchDigit.find()) {
            baseDamage += Double.parseDouble(matchDigit.group());
        }
        while (matchMultiDivide.find()) {
            if (matchMultiDivide.group().equals("*")) {
                baseDamage = baseDamage * 2;
            } else if (matchMultiDivide.group().equals("/")) {
                baseDamage = baseDamage / 2;
            }
        }


        return baseDamage;
    }
}
