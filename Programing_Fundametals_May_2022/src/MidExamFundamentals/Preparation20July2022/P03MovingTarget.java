package MidExamFundamentals.Preparation20July2022;

import com.sun.source.tree.WhileLoopTree;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> targets = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String inputLine = scanner.nextLine();

        while (!inputLine.equals("End")) {
            List<String> commandLine = Arrays.stream(inputLine.split(" "))
                    .collect(Collectors.toList());
            String command = commandLine.get(0);

            if ("Shoot".equals(command)) {
                int index = Integer.parseInt(commandLine.get(1));
                int power = Integer.parseInt(commandLine.get(2));
                if (isValidIndex(targets, index)) {
                    int valueOfTarget = targets.get(index);
                    valueOfTarget -= power;
                    if (valueOfTarget <= 0) {
                        targets.remove(index);
                    } else {
                        targets.set(index, valueOfTarget);
                    }
                }
//                } else {
//                    System.out.println("Invalid placement!");
//                }
            } else if ("Add".equals(command)) {
                int index = Integer.parseInt(commandLine.get(1));
                int value = Integer.parseInt(commandLine.get(2));
                if (isValidIndex(targets, index)) {
                    targets.add(index, value);
                } else {
                    System.out.println("Invalid placement!");
                }
            } else if ("Strike".equals(command)) {
                int index = Integer.parseInt(commandLine.get(1));
                int radius = Integer.parseInt(commandLine.get(2));
                if (isValidRadios(targets, index, radius)) {
                    for (int i = 0; i < 2 * radius + 1; i++) {
                        targets.remove(index - radius);
                    }
                } else {
                    System.out.println("Strike missed!");
                }
            }


            inputLine = scanner.nextLine();
        }

        System.out.println(targets.toString().replaceAll("[\\[\\],]", "").replaceAll(" ", "\\|"));

    }

    private static boolean isValidRadios(List<Integer> targets, int index, int radius) {

        return (index - radius) >= 0 && (index + radius) < targets.size();
    }

    private static boolean isValidIndex(List<Integer> targets, int index) {
        return index >= 0 && index < targets.size();
    }
}
