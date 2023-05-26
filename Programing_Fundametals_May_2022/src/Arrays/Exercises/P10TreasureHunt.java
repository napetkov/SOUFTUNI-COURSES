package Arrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P10TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] treasure = scanner.nextLine().split("\\|");
        String input = scanner.nextLine();
        while (!input.equals("Yohoho!")) {
            String[] commandArr = input.split(" ");
            String command = commandArr[0];
            switch (command) {
                case "Loot":
                    String newItems = "";
                    boolean alreadyContained = false;

                    for (int j = commandArr.length - 1; j > 0; j--) {
                        alreadyContained = false;
                        for (int i = 0; i < treasure.length; i++) {
                            if (commandArr[j].equals(treasure[i])) {
                                alreadyContained = true;
                                break;
                            }
                        }
                        if (!alreadyContained) {
                            newItems = newItems + commandArr[j] + " ";
                        }
                    }
                    for (int i = 0; i < treasure.length; i++) {
                        newItems += treasure[i] + " ";
                    }
                    treasure = newItems.split(" ");
                    break;
                case "Drop":
                    int dropIndex = Integer.parseInt(commandArr[1]);
                    if ((treasure.length - 1) < dropIndex || dropIndex < 0) {
                        break;
                    }
                    String dropItem = treasure[dropIndex];
                    for (int i = dropIndex; i < treasure.length - 1; i++) {
                        treasure[i] = treasure[i + 1];
                    }
                    treasure[treasure.length - 1] = dropItem;
                    break;
                case "Steal":
                    int stealIndex = Integer.parseInt(commandArr[1]);
                    if(stealIndex> treasure.length){
                        stealIndex = treasure.length;
                    }
                    String stealItems = "";
                    int counterItems = stealIndex;
                    for (int i = 0; i < stealIndex; i++) {
                        stealItems += treasure[treasure.length - counterItems] + " ";
                        counterItems -= 1;
                    }
                    String [] stealItemsArr = stealItems.split(" ");
                    System.out.println(String.join(", ",stealItemsArr));
                    newItems = "";
                    for (int i = 0; i < treasure.length - stealIndex; i++) {
                        newItems += treasure[i] + " ";
                    }
                    treasure = newItems.split(" ");
                    break;
            }
            input = scanner.nextLine();
        }
        double treasureGain = 0;
        for (int i = 0; i < treasure.length; i++) {
            treasureGain += treasure[i].length();
        }
        double averageTreasureGain = treasureGain / treasure.length;
        if (averageTreasureGain == 0) {
            System.out.println("Failed treasure hunt.");
        } else {
            System.out.printf("Average treasure gain: %.2f pirate credits.", averageTreasureGain);
        }
    }
}
