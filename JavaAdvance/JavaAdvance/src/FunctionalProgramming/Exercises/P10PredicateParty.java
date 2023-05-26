package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P10PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> quests = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String commandLine = scanner.nextLine();

        while(!commandLine.equals("Party!")){
            String command = commandLine.split("\\s+")[0];
            String filter = commandLine.split("\\s+")[1];
            String parameter = commandLine.split("\\s+")[2];

            Predicate<String> filterToApply  = getPredicate(filter,parameter);

            if(command.equals("Double")){
               List<String> currentQuest = quests.stream().filter(filterToApply).collect(Collectors.toList());
                quests.addAll(currentQuest);

            }else{
                quests.removeIf(filterToApply);
            }

            commandLine = scanner.nextLine();
        }
        System.out.println();
        if(quests.isEmpty()){
            System.out.println("Nobody is going to the party!");
        }else{
            System.out.println(quests.stream().sorted().collect(Collectors.joining(", "))
                    +" are going to the party!");
        }


    }

    private static Predicate<String> getPredicate(String filter, String parameter) {

        switch (filter){
            case "StartsWith":
                return s-> s.startsWith(parameter);
            case "EndsWith":
                return s-> s.endsWith(parameter);
            case "Length":
                return s->s.length()==Integer.parseInt(parameter);
        }
        return null;
    }
}
