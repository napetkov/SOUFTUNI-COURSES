package SetsAndMapsAdvanced.Lab;

import com.sun.source.doctree.LinkTree;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P02SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Set<String> partiList = new TreeSet<>();

        while (!input.equals("PARTY")) {
            partiList.add(input);

            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while(!input.equals("END")){
            partiList.remove(input);

            input = scanner.nextLine();
        }

        System.out.println(partiList.size());
        partiList.forEach(System.out::println);

    }
}
