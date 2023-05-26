package FinalExamParparation.Parparation27July2022;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class P02DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("(@|#)(?<wordOne>[A-Za-z]{3,})\\1\\1(?<wordTwo>[A-Za-z]{3,})\\1");
        Matcher matcher = pattern.matcher(input);
        List<String> mirrorWord = new ArrayList<>();
        int counterPairs = 0;
        boolean haveMatch= false;

            while (matcher.find()) {
                String wordOne = matcher.group("wordOne");
                String wordTwo = matcher.group("wordTwo");
                StringBuilder reversedWord = new StringBuilder(wordTwo);
                reversedWord = reversedWord.reverse();
                counterPairs++;
                haveMatch = true;

                if (wordOne.equals(reversedWord.toString())) {
                    mirrorWord.add(wordOne + " <=> " + wordTwo);
                }
            }
            if(haveMatch) {
                System.out.printf("%d word pairs found!%n", counterPairs);
            }else{
                System.out.println("No word pairs found!");
            }




        if (mirrorWord.isEmpty()) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            System.out.println(mirrorWord.toString().replaceAll("[\\[\\]]",""));


        }

    }

}

