package DefineAnInterfacePerson;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Birthable> birthables = new ArrayList<>();

        while (!"End".equals(input)) {
            String[] data = input.split("\\s+");
            String typeObject = data[0];


            Birthable birthable;

            String id;
            String name;
            String birthDate;
            switch (typeObject) {
                case "Citizen":
                    name = data[1];
                    int age = Integer.parseInt(data[2]);
                    id = data[3];
                    birthDate = data[4];
                    
                    birthable = new Citizen(name, age, id, birthDate);
                    birthables.add(birthable);
                    break;
                case "Robot":
                    id = data[1];
                    String model = data[2];

                    Identifiable identifiable = new Robot(id, model);
                    break;
                case "Pet":
                    name = data[1];
                    birthDate = data[2];

                    birthable = new Pet(name, birthDate);
                    birthables.add(birthable);
                    break;
            }

            input = scanner.nextLine();
        }
        String existingYear = scanner.nextLine();

        birthables.stream()
                .map(Birthable::getBirthDate)
                .filter(e->e.endsWith(existingYear))
                .forEach(System.out::println);
    }
}
