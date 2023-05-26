package FinalExamParparation.Practice;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfHeroes = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> heroHP = new LinkedHashMap<>();
        Map<String, Integer> heroMP = new LinkedHashMap<>();

        for (int i = 0; i < numberOfHeroes; i++) {
            String input = scanner.nextLine();

            String heroName = input.split(" ")[0];
            int hitPoints = Integer.parseInt(input.split(" ")[1]);
            int manaPoints = Integer.parseInt(input.split(" ")[2]);
            heroHP.put(heroName, hitPoints);
            heroMP.put(heroName, manaPoints);
        }

        String commandLine = scanner.nextLine();

        while (!commandLine.equals("End")) {

            String command = commandLine.split(" - ")[0];
            String heroName = commandLine.split(" - ")[1];
            int amount = 0;
            int currentHP = 0;
            int currentMP = 0;

            switch (command) {
                case "CastSpell":
                    int neededMP = Integer.parseInt(commandLine.split(" - ")[2]);
                    String spellName = commandLine.split(" - ")[3];
                    currentMP = heroMP.get(heroName);

                    if (currentMP >= neededMP) {
                        currentMP -= neededMP;
                        heroMP.put(heroName, currentMP);
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroName,spellName, currentMP);
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(commandLine.split(" - ")[2]);
                    String attacker = commandLine.split(" - ")[3];

                    currentHP = heroHP.get(heroName);
                    currentHP -= damage;

                    if (currentHP > 0) {
                        heroHP.put(heroName, currentHP);
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", heroName, damage, attacker, currentHP);

                    } else {
                        System.out.printf("%s has been killed by %s!%n", heroName, attacker);
                        heroHP.remove(heroName);
                        heroMP.remove(heroName);

                    }
                    break;
                case "Recharge":
                    amount = Integer.parseInt(commandLine.split(" - ")[2]);
                    currentMP = heroMP.get(heroName);

                    if((currentMP+amount)>200){
                        int amountRecovered =200-currentMP;
                        currentMP = 200;

                        System.out.printf("%s recharged for %d MP!%n",heroName,amountRecovered);

                    }else{
                        currentMP +=amount;
                        System.out.printf("%s recharged for %d MP!%n",heroName,amount);
                    }
                    heroMP.put(heroName,currentMP);
                    break;
                case "Heal":
                    amount = Integer.parseInt(commandLine.split(" - ")[2]);
                    currentHP = heroHP.get(heroName);

                    if((currentHP+amount)>100){
                        int amountRecovered =100-currentHP;
                        currentHP = 100;

                        System.out.printf("%s healed for %d HP!%n",heroName,amountRecovered);

                    }else{
                        currentHP +=amount;
                        System.out.printf("%s healed for %d HP!%n",heroName,amount);
                    }
                    heroHP.put(heroName,currentHP);
                    break;
            }
            commandLine = scanner.nextLine();
        }
        heroHP.entrySet().forEach(entry->{
            System.out.println(entry.getKey());
            System.out.printf("  HP: %s%n",entry.getValue());
            System.out.printf("  MP: %s%n",heroMP.get(entry.getKey()));
        });

    }
}
