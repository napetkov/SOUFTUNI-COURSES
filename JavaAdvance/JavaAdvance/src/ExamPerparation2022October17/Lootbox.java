package ExamPerparation2022October17;

import java.util.*;

public class Lootbox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstBox = new ArrayDeque<>();
        ArrayDeque<Integer> secondBox = new ArrayDeque<>();

        List<Integer> claimedItems = new ArrayList<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(firstBox::offer);
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(secondBox::push);

        while (!firstBox.isEmpty() && !secondBox.isEmpty()) {
            int sumItems = firstBox.peek() + secondBox.peek();

            if (sumItems % 2 == 0) {
                claimedItems.add(sumItems);
                firstBox.poll();
                secondBox.pop();
            } else {
                firstBox.offer(secondBox.pop());
            }
        }

        int claimedSum = 0;
        for (int integer:claimedItems){
            claimedSum += integer;
        }

        if(firstBox.isEmpty()) {
            System.out.println("First lootbox is empty");
        }else{
            System.out.println("Second lootbox is empty");
        }
        if(claimedSum>=100){
            System.out.printf("Your loot was epic! Value: %d",claimedSum);
        }else{
            System.out.printf("Your loot was poor... Value: %d",claimedSum);
        }

    }
}
