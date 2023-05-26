package DefiningClasses.Exercises.P01OpinionPoll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        List<Person> listOfPerson = new ArrayList<>();

        for (int i = 0; i < numberOfPeople; i++) {
            String[] personData = scanner.nextLine().split("\\s+");
            String firstName = personData[0];
            int age = Integer.parseInt(personData[1]);

            Person person = new Person(firstName, age);

            listOfPerson.add(person);
        }

        listOfPerson.stream().filter(person -> person.getAge()>30).
                sorted((left,right)->left.getName().compareTo(right.getName()))
                .forEach(System.out::println);



    }
}
