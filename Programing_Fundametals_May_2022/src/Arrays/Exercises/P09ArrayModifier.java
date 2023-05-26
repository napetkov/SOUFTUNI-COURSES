package Arrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P09ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputArr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] command = input.split(" ");
            String typeOfCommand = command[0];
            int index1 = 0;
            int index2 = 0;
            switch (typeOfCommand) {
                case "swap":
                    index1 = Integer.parseInt(command[1]);
                    index2 = Integer.parseInt(command[2]);
                    int oldElement = inputArr[index1];
                    inputArr[index1] = inputArr[index2];
                    inputArr[index2] = oldElement;
                    break;
                case "multiply":
                     index1 = Integer.parseInt(command[1]);
                     index2 = Integer.parseInt(command[2]);
                    inputArr[index1] = inputArr[index1]*inputArr[index2];
                    break;
                case "decrease":
                    for (int i = 0; i < inputArr.length; i++) {
                        inputArr[i] -=1;
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        String[] output = Arrays.stream(inputArr)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);
        System.out.println(String.join(", ",output));
    }
}
