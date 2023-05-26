package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Class<RichSoilLand> clazz = RichSoilLand.class;

        Field[] fields = clazz.getDeclaredFields();

        String command = scanner.nextLine();

        while (!"HARVEST".equals(command)) {

            switch (command) {
                case "private":
                    for (Field field : fields) {
                        int modifier = field.getModifiers();
                        if (Modifier.isPrivate(modifier)) {
                            printFields(modifier, field);
                        }
                    }
                    break;
                case "protected":
                    for (Field field : fields) {
                        int modifier = field.getModifiers();
                        if (Modifier.isProtected(modifier)) {

                            printFields(modifier, field);
                        }
                    }
                    break;
                case "public":
                    for (Field field : fields) {
                        int modifier = field.getModifiers();
                        if (Modifier.isPublic(modifier)) {

                            printFields(modifier, field);
                        }
                    }
                    break;
                case "all":
                    for (Field field : fields) {
                        int modifier = field.getModifiers();

                        printFields(modifier, field);
                    }
                    break;
            }

            command = scanner.nextLine();
        }

    }

    private static void printFields(int modifier, Field field) {
        String typeModifier = Modifier.toString(modifier);
        System.out.println(typeModifier + " " + field.getType().getSimpleName() + " " + field.getName());
    }
}
