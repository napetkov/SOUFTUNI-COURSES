package StramFilesAndDirectories.Exercises;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;



public class P06WordCount {
    public static void main(String[] args) throws IOException {

        Scanner wordsScanner = new Scanner(new FileReader("Exercises-Resources/words.txt"));

        String[] wordToSearch = wordsScanner.nextLine().split(" ");

        PrintWriter pw = new PrintWriter(new FileWriter("Exercises-Resources/result.txt"));

        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

        for (String toSearch : wordToSearch) {
            map.put(toSearch, 0);
        }

        Scanner fileScanner = new Scanner(new FileReader("Exercises-Resources/text.txt"));

        String singleWord = fileScanner.next();

        while (fileScanner.hasNext()) {
            if (map.containsKey(singleWord)) {
                int currentCount = map.get(singleWord);
                map.put(singleWord, currentCount+1);
            }

            singleWord = fileScanner.next();
        }

        map.entrySet().stream().sorted((f,s)-> s.getValue()-f.getValue())
                        .forEach(entry-> {
                            pw.printf("%s - %d%n",entry.getKey(),map.get(entry.getKey()));
                        });

        wordsScanner.close();
        fileScanner.close();

        pw.close();


    }


}
