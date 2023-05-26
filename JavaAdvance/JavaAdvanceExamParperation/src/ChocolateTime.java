import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class ChocolateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Double> milk = new ArrayDeque<>();
        ArrayDeque<Double> cacao = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .forEach(milk::offer);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .forEach(cacao::push);

        TreeMap<String, Integer> chocolates = new TreeMap<>();


        while (!milk.isEmpty() && !cacao.isEmpty()) {
            double currentMilk = milk.poll();
            double currentCacao = cacao.pop();
            double cacaoPercentage = currentCacao / (currentMilk + currentCacao) * 100;
            String type = "";

            if (cacaoPercentage == 30) {
                collectChocolate(chocolates, "Milk Chocolate");
            } else if (cacaoPercentage == 50) {
                collectChocolate(chocolates, "Dark Chocolate");
            } else if (cacaoPercentage == 100) {
                collectChocolate(chocolates, "Baking Chocolate");
            } else {
                currentMilk += 10;
                milk.offer(currentMilk);
            }
        }

        if (chocolates.size() == 3) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }

        chocolates.forEach((k, v) -> System.out.printf("# %s --> %d%n", k, v));

    }

    private static void collectChocolate(TreeMap<String, Integer> chocolates, String type) {
        if (chocolates.containsKey(type)) {
            chocolates.put(type, chocolates.get(type) + 1);
        } else {
            chocolates.put(type, 1);
        }
    }
}
