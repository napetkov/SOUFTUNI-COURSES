package Generics.Lab.P04ListUtilities;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(17, 21, 13, 7);

        System.out.println(ListUtils.getMax(numbers));
        System.out.println(ListUtils.getMin(numbers));

        List<String> strings = List.of("asd","56","Oxxa","z");

        System.out.println(ListUtils.getMax(strings));
        System.out.println(ListUtils.getMin(strings));

    }
}
