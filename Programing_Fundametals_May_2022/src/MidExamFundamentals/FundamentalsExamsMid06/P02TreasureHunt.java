package MidExamFundamentals.FundamentalsExamsMid06;

import java.util.*;
import java.util.stream.Collectors;

public class P02TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> treasure = Arrays.stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Yohoho!")) {
            String[] commandLine = input.split(" ");
            String command = commandLine[0];

            switch (command) {
                case "Loot":
                    for (int i = 1; i < commandLine.length; i++) {
                        if (!treasure.contains(commandLine[i])) {
                            treasure.add(0, commandLine[i]);
                        }
                    }
                    break;
                case "Drop":
                    int index = Integer.parseInt(commandLine[1]);
                    if (isValidIndex(treasure, index)) {
                        treasure.add(treasure.get(index));
                        treasure.remove(index);
                    }
                    break;
                case "Steal":
                    int count = Integer.parseInt(commandLine[1]);
                    List<String> printList = new ArrayList<>();
                    if (count > treasure.size()) {
                        count = treasure.size();
                    }
                    for (int i = 0; i < count; i++) {
                        printList.add(treasure.get(treasure.size() - 1));
                        treasure.remove(treasure.size() - 1);

                    }
                    Collections.reverse(printList);
                    System.out.println(printList.toString().replaceAll("[\\[\\]]", ""));
                    break;
            }
            input = scanner.nextLine();
        }

        int sumOfLength = 0;
        for (int i = 0; i < treasure.size(); i++) {
            sumOfLength += treasure.get(i).length();
        }
        if (treasure.isEmpty()) {
            System.out.println("Failed treasure hunt.");
        } else {
            double averageTreasureGain = sumOfLength * 1.00 / treasure.size();

            System.out.printf("Average treasure gain: %.2f pirate credits.", averageTreasureGain);
        }


    }


    private static boolean isValidIndex(List<String> treasure, int index) {
        return index >= 0 && index < treasure.size();
    }
}
