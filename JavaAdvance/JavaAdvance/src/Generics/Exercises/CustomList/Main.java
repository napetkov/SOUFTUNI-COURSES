package Generics.Exercises.CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        CustomList<String> customList = new CustomList<>();

        while (!command.equals("END")) {
            String commandName = command.split(" ")[0];

            switch (commandName) {
                case "Add":
                    String elementToAdd = command.split(" ")[1];
                    customList.add(elementToAdd);
                    break;

                case "Remove":
                    int index = Integer.parseInt(command.split(" ")[1]);
                customList.remove(index);
                    break;

                case "Contains":
                    String elementToContains = command.split(" ")[1];
                    customList.contains(elementToContains);
                    break;

                case "Swap":
                    int firstIndex = Integer.parseInt(command.split(" ")[1]);
                    int secondIndex = Integer.parseInt(command.split(" ")[2]);
                    customList.swap(firstIndex,secondIndex);
                    break;

                case "Greater":
                    String elementToCompare = command.split(" ")[1];
                    customList.countGreaterElements(elementToCompare);
                    break;

                case "Max":
                    customList.max();
                    break;

                case "Min":
                    customList.min();
                    break;
                case "Sort":
                    Sorter.sort(customList);
                    break;
                case "Print":
                    customList.print();
                    break;
            }

            command = scanner.nextLine();
        }

    }
}
