import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortByNameAndAge {
    public static class Person {
        private String firstName;
        private String lastName;
        private int age;

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public String getFirstName() {
            return firstName;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return String.format("%s %s is %d years old.",firstName,lastName,age);
        }
    }

    public static class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(reader.readLine());

            List<Person> people = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String[] input = reader.readLine().split(" ");
                people.add(new Person(input[0], input[1], Integer.parseInt(input[2])));
            }

            people.sort(Comparator.comparing(Person::getFirstName).thenComparing(Person::getAge));

            for (Person person : people) {
                System.out.println(person.toString());
            }
        }

    }
}
