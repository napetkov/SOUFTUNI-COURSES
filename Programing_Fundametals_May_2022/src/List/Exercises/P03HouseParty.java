package List.Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbersIfCommands = Integer.parseInt(scanner.nextLine());
        List<String> housePartyList = new ArrayList<>();
        boolean isFirstElement = true;

        for (int i = 0; i < numbersIfCommands; i++) {
            List<String> commandList = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
            String command = commandList.get(2);
            String nameOfGuest = commandList.get(0);
            switch (command) {
                case "going!":
                    if(housePartyList.contains(nameOfGuest)){
                        System.out.printf("%s is already in the list!%n",nameOfGuest);
                    }else{
                        housePartyList.add(nameOfGuest);
                    }

                    break;
                case "not":
                    if (housePartyList.contains(nameOfGuest)) {
                        housePartyList.removeIf(e -> e.equals(nameOfGuest));
                    } else {
                        System.out.printf("%s is not in the list!%n",nameOfGuest);
                    }
                    break;
            }
        }

        for (String currentEl:housePartyList) {
            System.out.println(currentEl);

        }
    }

}
