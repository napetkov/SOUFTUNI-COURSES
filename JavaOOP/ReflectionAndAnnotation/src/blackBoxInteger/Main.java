package blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);

        Class<BlackBoxInt> clazz = BlackBoxInt.class;

        Field innerValue = clazz.getDeclaredField("innerValue");
        innerValue.setAccessible(true);

        Constructor<BlackBoxInt> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBox = constructor.newInstance();

        String input = scanner.nextLine();

        while (!"END".equals(input)) {
            String[] commandLine = input.split("_");
            String command = commandLine[0];
            int value = Integer.parseInt(commandLine[1]);

            Method method = clazz.getDeclaredMethod(command,int.class);
            method.setAccessible(true);
            method.invoke(blackBox,value);

            System.out.println(innerValue.get(blackBox));

            input = scanner.nextLine();
        }
    }
}
