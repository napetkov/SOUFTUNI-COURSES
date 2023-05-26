package RegularExpressions.Exercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class P02Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> racerList = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        Map<String, Integer> racersMap = new LinkedHashMap<>();
        racerList.forEach(element -> racersMap.put(element, 0));


        String input = scanner.nextLine();

        Pattern letter = Pattern.compile("[A-Za-z]+");
        Pattern digit = Pattern.compile("[0-9]");

        while (!input.equals("end of race")) {
            int distance = 0;

            StringBuilder nameBuilder = new StringBuilder();

            Matcher matchLetter = letter.matcher(input);
            Matcher matchDigit = digit.matcher(input);
            while (matchLetter.find()) {
                nameBuilder.append(matchLetter.group());
            }
            while (matchDigit.find()) {
                distance += Integer.parseInt(matchDigit.group());
            }

            String name = nameBuilder.toString();
            if (racersMap.containsKey(name)) {
                int currentDistance = racersMap.get(name);
                racersMap.put(name, currentDistance + distance);
            }


            input = scanner.nextLine();
        }
        List<String> nameOfFirstTree = racersMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3) // взима първите три записа
                .map(entry -> entry.getKey()).collect(Collectors.toList());//на евсеки запис от мапа взимаме ключа и го записваме в лист.

        System.out.println("1st place: "+nameOfFirstTree.get(0));
        System.out.println("2nd place: "+nameOfFirstTree.get(1));
        System.out.println("3rd place: "+nameOfFirstTree.get(2));

    }
}
