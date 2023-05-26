package DefiningClasses.Exercises.P07Google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> personMap = new HashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {

            String data[] = input.split("\\s+");
            String name = data[0];
            String command = data[1];

            if(!isRealPerson(name,personMap)){
                Person person = new Person();
                person.setName(name);
                personMap.put(name,person);
            }


            switch (command) {
                case "company":
                    setCompany(personMap, data,name);
                    break;
                case "pokemon":
                    addPokemon(personMap, data, name);
                    break;
                case "parents":
                    addParent(personMap, data, name);
                    break;
                case "children":
                    addChild(personMap, data, name);
                    break;
                case "car":
                    setCar(personMap, data, name);
                    break;

            }
            input = scanner.nextLine();
        }

        String nameToFind = scanner.nextLine();

        System.out.println(personMap.get(nameToFind).toString());
    }

    private static void setCar(Map<String, Person> personMap, String[] data, String name) {
        String carModel = data[2];
        String carSpeed = data[3];
        Car car = new Car(carModel,carSpeed);
        personMap.get(name).setCar(car);
    }

    private static void addChild(Map<String, Person> personMap, String[] data, String name) {
        String childName = data[2];
        String childBirthday = data[3];
        Child child = new Child(childName,childBirthday);
        personMap.get(name).getChildren().add(child);
    }

    private static void setCompany(Map<String,Person> personMap, String[] data,String name) {
        String companyName = data[2];
        String department = data[3];
        double salary = Double.parseDouble(data[4]);
        Company company = new Company(companyName,department,salary);
        personMap.get(name).setCompany(company);
    }

    private static void addParent(Map<String, Person> personMap, String[] data, String name) {
        String parentName = data[2];
        String parentBirthday = data[3];
        Parent parent = new Parent(parentName,parentBirthday);
        personMap.get(name).getParents().add(parent);
    }

    private static void addPokemon(Map<String, Person> personMap, String[] data, String name) {
        String pokemonName = data[2];
        String pokemonType = data[3];
        Pokemon pokemon = new Pokemon(pokemonName,pokemonType);
        personMap.get(name).getPokemons().add(pokemon);
    }

    private static boolean isRealPerson(String name, Map<String, Person> personMap) {
    return personMap.containsKey(name);
    }


}
