package FinalExamParparation.Practice;

import java.util.*;

public class SantasNewList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String,Integer> childrenAmount = new TreeMap<>();
        Map<String,Integer> presentsAmount = new LinkedHashMap<>();

        while(!input.equals("END")){
            String childName = "";
            if(!input.split("->")[0].equals("Remove")){
                childName = input.split("->")[0];
                String present = input.split("->")[1];
                int amount = Integer.parseInt(input.split("->")[2]);

                if(childrenAmount.containsKey(childName)){
                    int currentAmount = childrenAmount.get(childName);
                    childrenAmount.put(childName,currentAmount+amount);
                }else{
                    childrenAmount.put(childName,amount);
                }

                if(presentsAmount.containsKey(present)){
                    int currentAmount = presentsAmount.get(present);
                    presentsAmount.put(present,currentAmount+amount);
                }else{
                    presentsAmount.put(present,amount);
                }

            }else{
                childName = input.split("->")[1];
                childrenAmount.remove(childName);
            }

            input = scanner.nextLine();
        }
//        entry.getValue().entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
//                .forEach(element-> {
//                    System.out.printf("#  %s -> %d%n",element.getKey(),element.getValue());
//                });
        System.out.println("Children:");
        childrenAmount.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .forEach(entry->{
                    System.out.printf("%s -> %d%n",entry.getKey(),entry.getValue());
                });
        System.out.println("Presents:");
        presentsAmount.entrySet().forEach(entry->{
            System.out.printf("%s -> %d%n",entry.getKey(),entry.getValue());
        });

    }
}
