package List.Lab;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class P06ListOfProducts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbers = Integer.parseInt(scanner.nextLine());
        List<String> productsList = new ArrayList<>();
        for (int i = 0; i < numbers; i++) {
            productsList.add(scanner.nextLine());
        }
        Collections.sort(productsList);

        for (int i = 0; i < productsList.size(); i++) {
            System.out.printf("%d.%s%n",i+1,productsList.get(i));
        }

    }
}
