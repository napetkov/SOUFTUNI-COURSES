package IteratorsAndComparators.Exercises.StrategyPattern;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbersOfPerson = Integer.parseInt(scanner.nextLine());

        TreeSet<Person> nameSet = new TreeSet<>(new PersonNameComparator());
        TreeSet<Person> ageSet = new TreeSet<>(new PersonAgeComparator());

        for (int i = 0; i < numbersOfPerson; i++) {
            String[] personData = scanner.nextLine().split(" ");
            String name = personData[0];
            int age = Integer.parseInt(personData[1]);

            Person person = new Person(name,age);

            nameSet.add(person);
            ageSet.add(person);
        }


        nameSet.forEach(person -> System.out.println(person.toString()));
        ageSet.forEach(person -> System.out.println(person.toString()));
    }
}
