import java.util.*;
import java.util.stream.Collectors;

public class P01ApocalypsePreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> itemsMap = new HashMap<>();

        ArrayDeque<Integer> textiles = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(textiles::offer);


        String[] medicamentInput = scanner.nextLine().split("\\s+");
        Deque<Integer> medicaments = new ArrayDeque<>();
        for (String medicament : medicamentInput) {
            medicaments.push(Integer.parseInt(medicament));
        }

        while (textiles.size() > 0 && medicaments.size() > 0) {
            int currentTextile = textiles.pop();
            int currentMedicament = medicaments.poll();
            int sumOfElements = currentTextile + currentMedicament;

            switch (sumOfElements) {
                case 30:
                    createItems(itemsMap, "Patch");
                    break;
                case 40:
                    createItems(itemsMap, "Bandage");
                    break;
                case 100:
                    createItems(itemsMap, "MedKit");
                    break;
                default:
                    if (sumOfElements > 100) {
                        createItems(itemsMap, "MedKit");
                        int difference = sumOfElements - 100;
                        int nextElementInMedicaments = medicaments.poll() + difference;
                        medicaments.push(nextElementInMedicaments);
                    } else {
                        currentMedicament += 10;
                        medicaments.push(currentMedicament);
                    }
            }
        }

        boolean leftTextile = false;
        boolean leftMedicament = false;

        if (textiles.isEmpty() && medicaments.isEmpty()){
            System.out.println("Textiles and medicaments are both empty.");
        }else if(medicaments.isEmpty()){
            System.out.println("Medicaments are empty.");
            leftTextile = true;
        }else if(textiles.isEmpty()){
            System.out.println("Textiles are empty.");
            leftMedicament = true;
        }


        List<Map.Entry<String, Integer>> orderedItems =
                new ArrayList<>(itemsMap.entrySet());
        orderedItems.sort(Comparator.comparing(Map.Entry<String, Integer>::getValue).reversed().
                thenComparing(Map.Entry<String, Integer>::getKey));

        orderedItems.forEach((element) -> {
            System.out.printf("%s - %d\n",element.getKey(),element.getValue());
        });

        if(leftMedicament){
            String[] result = medicaments.stream()
                    .map(String::valueOf)
                    .toArray(String[]::new);
            System.out.println("Medicaments left: " + String.join( ", ", result));
        }
        if(leftTextile){
            String[] result = textiles.stream()
                    .map(String::valueOf)
                    .toArray(String[]::new);
            System.out.println("Textiles left: " + String.join( ", ", result));
        }
    }

    private static void createItems(Map<String, Integer> itemsMap, String item) {
        if (itemsMap.containsKey(item)) {
            int currentCount = itemsMap.get(item);
            currentCount++;
            itemsMap.put(item, currentCount);
        } else {
            itemsMap.put(item, 1);
        }
    }
}
