package FinalExamParparation.Practice;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int coolThreshold = 1;

        Pattern digits = Pattern.compile("[0-9]");
        Pattern emojis = Pattern.compile("(:{2}|\\*{2})(?<emojis>[A-Z][a-z]{2,})\\1");
        Matcher matchDigits = digits.matcher(input);
        Matcher matchEmojis = emojis.matcher(input);

        Map<String, Integer> coolOnesEmojis = new LinkedHashMap<>();

        while (matchDigits.find()) {
            coolThreshold = coolThreshold * Integer.parseInt(matchDigits.group());
        }
        while (matchEmojis.find()) {
            String emoji = matchEmojis.group("emojis");
            int currentCoolThreshold = 0;

            for (int i = 0; i < emoji.length(); i++) {
                currentCoolThreshold += (int) emoji.charAt(i);
            }
            String printEmoji = matchEmojis.group();
            coolOnesEmojis.put(printEmoji, currentCoolThreshold);

        }
        System.out.println("Cool threshold: " + coolThreshold);
        System.out.println(coolOnesEmojis.size() + " emojis found in the text. The cool ones are:");
        int finalCoolThreshold = coolThreshold;
        coolOnesEmojis.entrySet().forEach(entry->{
            if(entry.getValue()> finalCoolThreshold){
                System.out.println(entry.getKey());
            }
        });

    }
}
