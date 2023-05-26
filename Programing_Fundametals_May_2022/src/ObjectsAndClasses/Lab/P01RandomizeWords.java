package ObjectsAndClasses.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01RandomizeWords {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> wordsList = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        while(!wordsList.isEmpty()){

            Random random = new Random();
            int sizeWordList = wordsList.size();
            int randomIndex = random.nextInt(sizeWordList);
            System.out.println(wordsList.get(randomIndex));
            wordsList.remove(randomIndex);

        }


    }
}
