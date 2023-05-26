package FunctionalProgramming.Exercises;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P11ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> quests = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        Set<String> filters = new HashSet<>();

        String command = scanner.nextLine();

        while (!command.equals("Print")) {
            String[] commandParts = command.split(";");
            String addOrRemove = commandParts[0];
            String type = commandParts[1];
            String parameter = commandParts[2];
            if (commandParts[0].equals("Add filter")) {
                filters.add(type + ";" + parameter);
            } else {
                filters.remove(type + ";" + parameter);
            }
            command = scanner.nextLine();
        }

        filters.forEach(filter -> {
            Predicate<String> filterToApply = getPregicate(filter);
            quests.removeIf(filterToApply);

        });

        quests.forEach(s -> System.out.print(s + " "));


    }

    private static Predicate<String> getPregicate(String filter) {
        String typeFilter = filter.split(";")[0];
        String parameter = filter.split(";")[1];

        switch (typeFilter) {
            case "Starts with":
                return s -> s.startsWith(parameter);
            case "Ends with":
                return s -> s.endsWith(parameter);
            case "Length":
                return s -> s.length() == Integer.parseInt(parameter);
            case "Contains":
                return s -> s.contains(parameter);
        }
        return null;
    }
}
