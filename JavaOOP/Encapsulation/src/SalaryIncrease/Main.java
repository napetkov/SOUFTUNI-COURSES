package SalaryIncrease;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Team team = new Team("Black Eagles");

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split("\\s+");

//            Optional<Person> person = Optional.empty();

            Person person = null;

            try {
                //Optional.of()
                person = new Person(
                        input[0], input[1], Integer.parseInt(input[2]), Double.parseDouble(input[3]));
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
            //person.ifPresent(people::add);

          team.addPlayer(person);


        }

//        double bonus = Double.parseDouble(reader.readLine());

        people.sort(Comparator.comparing(Person::getFirstName).thenComparing(Person::getAge));

//        for (Person person : people) {
//            person.increaseSalary(bonus);
//            System.out.println(person.toString());
//        }
        System.out.printf("First team have %d players",team.getFirstTeam().size());
        System.out.println();
        System.out.printf("Reserve team have %d players",team.getReserveTeam().size());
    }

}
