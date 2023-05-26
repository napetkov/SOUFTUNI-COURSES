package MapsLambdaAndStreamAPI.Exercises;

import java.util.*;

public class P09ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> firstSide = new LinkedHashMap<>();
        Map<String, String> secondSide = new LinkedHashMap<>();


        String inputLine = scanner.nextLine();

        while (!inputLine.equals("Lumpawaroo")) {
            String[] commandLine = inputLine.split(" ");
            String command = commandLine[1];
            String side = null;
            String user = null;
            if (command.equals("|")) {
                side = commandLine[0];
                user = commandLine[2];

                if (!firstSide.containsValue(side)) {
                    firstSide.put(user, side);
                } else {
                    secondSide.put(user, side);
                }

                if ((!firstSide.containsKey(user)) && (!secondSide.containsKey(user))) {
                    if (firstSide.containsValue(side)) {
                        firstSide.put(user, side);
                    } else if (secondSide.containsValue(side)) {
                        secondSide.put(user, side);
                    }
                }

            } else if (command.equals("->")) {
                side = commandLine[2];
                user = commandLine[0];
                if (firstSide.containsKey(user)) {
                    secondSide.put(user, firstSide.get(user));
                    firstSide.remove(user);
                    System.out.printf("%s joins the %s side!", user, secondSide.get(user));
                } else if (secondSide.containsKey(user)) {
                    firstSide.put(user, secondSide.get(user));
                    secondSide.remove(user);
                    System.out.printf("%s joins the %s side!", user, firstSide.get(user));
                } else {
                    if (firstSide.containsValue(side)) {
                        firstSide.put(user, side);
                    } else if (secondSide.containsValue(side)) {
                        secondSide.put(user, side);
                    }
                    System.out.printf("%s joins the %s side!", user, side);
                }
            }

            inputLine = scanner.nextLine();
        }

        if (!firstSide.isEmpty()) {
            for (Map.Entry<String, String> entry : firstSide.entrySet()) {
                System.out.printf("Side: %s, Members: %d%n", entry.getValue(), firstSide.size());
                break;
            }
            for (Map.Entry<String, String> entry : firstSide.entrySet()) {
                System.out.printf("! %s%n", entry.getKey());
            }
        }
        if (!secondSide.isEmpty()){
            for (Map.Entry<String, String> entry : secondSide.entrySet()) {
                System.out.printf("Side: %s, Members: %d%n",entry.getValue(),secondSide.size());
                break;
            }
            for (Map.Entry<String, String> entry : secondSide.entrySet()) {
                System.out.printf("! %s%n",entry.getKey());
            }
        }

    }
}
