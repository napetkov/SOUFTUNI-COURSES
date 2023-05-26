import java.lang.reflect.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        Class<Reflection> clazz = Reflection.class;

        Method[] methods = clazz.getDeclaredMethods();

        Comparator<Method> comparator = Comparator.comparing(Method::getName);


        Set<Method> getters = new TreeSet<>(comparator);
        Set<Method> setters = new TreeSet<>(comparator);

        Set<Field> fields = Arrays.stream(clazz.getDeclaredFields())
                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Field::getName))));

        for (Method method : methods) {
            if (method.getName().contains("get")) {
                getters.add(method);
            } else if (method.getName().contains("set")) {
                setters.add(method);
            }
        }

        for (Field field : fields) {
            int modifier = field.getModifiers();
            if (!Modifier.isPrivate(modifier)) {
                System.out.println(field.getName() + " must be private!");
            }

        }

        for (Method getter : getters) {
            int modifier = getter.getModifiers();

            if (!Modifier.isPublic(modifier)) {
                System.out.println(getter.getName() + " have to be public!");

            }
        }
        for (Method method : setters) {
            int modifier = method.getModifiers();
            if (!Modifier.isPrivate(modifier)) {
                System.out.println(method.getName() + " have to be private!");
            }
        }

    }
}
