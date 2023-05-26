package ObjectsAndClasses.Exercises;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class P07OrderByAge {
    static class Person {
        String name;
        String personalID;
        int age;

        public Person(String name, String personalID, int age) {
            this.name = name;
            this.personalID = personalID;
            this.age = age;
        }

        public int getAge() {
            return age;
        }
//Stephan with ID: 524244 is 10 years old.
        @Override
        public String toString() {
            return name +" with ID: "+personalID+" is " + String.valueOf(age)+" years old.";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Person> personList = new ArrayList<>();
        while (!input.equals("End")) {
            String inputName = input.split(" ")[0];
            String inputPersonalID = input.split(" ")[1];
            int inputAge = Integer.parseInt(input.split(" ")[2]);

            Person currentPerson = new Person(inputName, inputPersonalID, inputAge);

            personList.add(currentPerson);

            input = scanner.nextLine();
        }

        personList.sort(Comparator.comparing(Person::getAge));

        for(Person element:personList){
            System.out.println(element.toString());
        }


    }

}
