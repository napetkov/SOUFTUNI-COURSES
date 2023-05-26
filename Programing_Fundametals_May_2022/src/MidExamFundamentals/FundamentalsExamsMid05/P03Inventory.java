package MidExamFundamentals.FundamentalsExamsMid05;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> itemsList = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());
        String input = scanner.nextLine();
        while (!input.equals("Craft!")) {
            String[] commandLine = input.split(" - ");
            String command = commandLine[0];
            String item = commandLine[1];
            switch (command) {
                case "Collect":
                    if(!itemsList.contains(item)){
                        itemsList.add(item);
                    }
                    break;
                case "Drop":
                    itemsList.removeIf(e -> e.equals(item));
                    break;
                case "Combine Items":
                    String[] combineArray = item.split(":");
                    String oldItem = combineArray[0];
                    String newItem = combineArray[1];
                    if(itemsList.contains(oldItem)){
                        for (int i = 0; i < itemsList.size(); i++) {
                            if(oldItem.equals(itemsList.get(i))){
                                itemsList.add(i+1,newItem);
                            }

                        }
                    }
                    break;
                case "Renew":
                    if(itemsList.contains(item)){
                        itemsList.remove(item);
                        itemsList.add(item);
                    }
                    break;
            }


            input = scanner.nextLine();
        }
        System.out.println(String.join(", ",itemsList));

    }
}
