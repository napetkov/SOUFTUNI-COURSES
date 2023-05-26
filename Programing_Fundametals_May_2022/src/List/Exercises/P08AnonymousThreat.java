package List.Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class P08AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> textList = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        String commandLine = scanner.nextLine();

        while (!commandLine.equals("3:1")) {
            List<String> commandList = Arrays.stream(commandLine.split(" ")).collect(Collectors.toList());
            String command = commandList.get(0);
            switch (command) {
                case "merge":
                    int startIndex = Integer.parseInt(commandList.get(1));
                    int endIndex = Integer.parseInt(commandList.get(2));

                    if (startIndex < 0) {
                        startIndex = 0;
                    }
                    if (endIndex > textList.size() - 1) {
                        endIndex = textList.size() - 1;
                    }
                    //валидиране на индекси
                    boolean isValidIndex = startIndex <= textList.size() - 1 && endIndex >= 0 && startIndex < endIndex;
                    if (isValidIndex) {

                        mergeCommand(textList, startIndex, endIndex);
                    }

                    break;
                case "divide":
                    int index = Integer.parseInt(commandList.get(1));
                    int parts = Integer.parseInt(commandList.get(2));
                    divideElementAtIndex(textList, index, parts);


                    break;
            }


            commandLine = scanner.nextLine();
        }

        System.out.println(String.join(" ",textList));
//        for (String text:textList) {
//            System.out.print(text + " ");
//
//        }
    }

    private static List divideElementAtIndex(List<String> textList, int index, int parts) {
        String elementForDivide = textList.get(index);
        textList.remove(index);
        int beginIndex = 0;
        int partSize = elementForDivide.length() / parts;
        for (int i = 1; i < parts; i++) {
            textList.add(index, elementForDivide.substring(beginIndex, beginIndex + partSize));
            beginIndex+=partSize;
            index++;
        }
        textList.add(index,elementForDivide.substring(beginIndex));//ако не зададем краен индек,то се взима до края на дължината

        return textList;
    }

    private static List mergeCommand(List<String> inputList, int startIndex, int endIndex) {
        String result = "";

        for (int i = startIndex; i <= endIndex; i++) {
            result += inputList.get(i);

        }
        for (int i = startIndex; i <= endIndex; i++) {
            inputList.remove(startIndex);
        }
        inputList.add(startIndex, result);


        return inputList;
    }
}
