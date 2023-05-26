package ObjectsAndClasses.Exercises;

import com.sun.tools.javac.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class P01AdvertisementMessage {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfMessages = Integer.parseInt(scanner.nextLine());

        List<String> phrasesList = new ArrayList<>();
        phrasesList.add("Excellent product.");
        phrasesList.add("Such a great product.");
        phrasesList.add("I always use that product.");
        phrasesList.add("Best product of its category.");
        phrasesList.add("Exceptional product.");
        phrasesList.add("I can’t live without this product.");

        List<String> eventList = new ArrayList<>();
        eventList.add("Now I feel good.");
        eventList.add("I have succeeded with this product.");
        eventList.add("Makes miracles. I am happy of the results!");
        eventList.add("I cannot believe but now I feel awesome.");
        eventList.add("Try it yourself, I am very satisfied.");
        eventList.add("I feel great!");

        List<String> authorList = new ArrayList<>();
        authorList.add("Diana");
        authorList.add("Petya");
        authorList.add("Stella");
        authorList.add("Elena");
        authorList.add("Katya");
        authorList.add("Iva");
        authorList.add("Annie");
        authorList.add("Eva");

        List<String> citiesList = new ArrayList<>();
        citiesList.add("Burgas");
        citiesList.add("Sofia");
        citiesList.add("Plovdiv");
        citiesList.add("Varna");
        citiesList.add("Ruse");

// Random random = new Random();
//            int sizeWordList = wordsList.size();
//            int randomIndex = random.nextInt(sizeWordList);
//            System.out.println(wordsList.get(randomIndex));
//            wordsList.remove(randomIndex);
        Random random = new Random();

        for (int i = 0; i < numberOfMessages; i++) {
            int randomPhraseIndex = random.nextInt(phrasesList.size());
            int randomEventIndex = random.nextInt(eventList.size());
            int randomAuthorIndex = random.nextInt(authorList.size());
            int randomCitiesIndex = random.nextInt(citiesList.size());
            System.out.printf("%s %s %s - %s.%n",phrasesList.get(randomPhraseIndex),
                    eventList.get(randomEventIndex),authorList.get(randomAuthorIndex),citiesList.get(randomCitiesIndex));
        }


    }
}
