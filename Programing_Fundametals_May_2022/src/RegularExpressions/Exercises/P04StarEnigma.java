package RegularExpressions.Exercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P04StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countMassage = Integer.parseInt(scanner.nextLine());
        Map<String, String> planetsMap = new TreeMap<>();
        int countAttackedPlanets = 0;
        int countDestroyedPlanets = 0;

        for (int i = 0; i < countMassage; i++) {
            String encryptedMassage = scanner.nextLine();
            String decryptedMassage = getDecryptedMassage(encryptedMassage);

            Pattern pattern = Pattern.compile("@(?<planetName>[A-za-z]+)[^@\\-!:>]*(?<population>:\\d+)[^@\\-!:>]*!(?<attackType>[AD])![^@\\-!:>]*->(?<soldierCount>\\d+)");
            Matcher matcher = pattern.matcher(decryptedMassage);

            if (matcher.find()) {
                String planet = matcher.group("planetName");
                String attackType = matcher.group("attackType");
                if (attackType.equals("A")) {
                    countAttackedPlanets++;
                } else if (attackType.equals("D")) {
                    countDestroyedPlanets++;
                }
                planetsMap.put(planet, attackType);

            }
        }
        //може да се направи с два листа за атакувани и за разрушени планети
        System.out.println("Attacked planets: " + countAttackedPlanets);
        planetsMap.entrySet().forEach(element -> {
            if (element.getValue().equals("A")) {
                System.out.println("-> " + element.getKey());
            }
        });
        System.out.println("Destroyed planets: " + countDestroyedPlanets);
        planetsMap.entrySet().forEach(element -> {
            if (element.getValue().equals("D")) {
                System.out.println("-> " + element.getKey());
            }
        });
    }

    private static String getDecryptedMassage(String encryptedMassage) {
        int countLetter = getSpecialLetterCount(encryptedMassage);
        StringBuilder decryptedMassage = new StringBuilder();
        for (char symbol : encryptedMassage.toCharArray()) {
            char newSymbol = (char) (symbol - countLetter);
            decryptedMassage.append(newSymbol);
        }

        return decryptedMassage.toString();
    }

    private static int getSpecialLetterCount(String encryptedMassage) {
        int count = 0;
        for (char symbol : encryptedMassage.toCharArray()) {
            switch (symbol) {
                case 's':
                case 't':
                case 'a':
                case 'r':
                case 'S':
                case 'A':
                case 'T':
                case 'R':
                    count++;
                    break;
            }

        }

        return count;
    }
}
