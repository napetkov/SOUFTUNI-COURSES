package MidExamFundamentals.FundametnalsExamsMid04;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> shoppingList = Arrays.stream(scanner.nextLine().split("!"))
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Go Shopping!")) {
            String[] commandLine = input.split(" ");
            String command = commandLine[0];
            String item = commandLine[1];

            switch (command) {
                case "Urgent":
                    if (!shoppingList.contains(item)) {
                        shoppingList.add(0, item);
                    }
                    break;
                case "Unnecessary":
                    shoppingList.removeIf(e -> e.equals(item));
                    break;
                case "Correct":
                    String newItem = commandLine[2];
                    for (int i = 0; i < shoppingList.size(); i++) {

                        if (shoppingList.get(i).equals(item)) {
                            shoppingList.set(i, newItem);
                                                    }
                    }
                    break;
                case "Rearrange":
                    if(shoppingList.contains(item)){
                        shoppingList.remove(item);
                        shoppingList.add(item);
                    }
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println(String.join(", ",shoppingList));

    }
}
