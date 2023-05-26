package Generics.Exercises.Box;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box<T extends Comparable<T>> {

    private List<T> values;

    public Box() {
        this.values = new ArrayList<>();
    }

    public void add(T element) {
        values.add(element);
    }

    public void swapElements(int firstIndex, int secondIndex) {
        if (isOnBounds(firstIndex, secondIndex)) {
            T currentElement = values.get(firstIndex);
            values.set(firstIndex, values.get(secondIndex));
            values.set(secondIndex, currentElement);
            //Collections.swap(values,firstIndex,secondIndex);

        } else {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }


    }

    private boolean isOnBounds(int firstIndex, int secondIndex) {
        return firstIndex >= 0 && firstIndex < values.size() && secondIndex >= 0 && secondIndex < values.size();
    }

    public int countOfGrater(T elementToCompare ) {
        return (int) values.stream()
                .filter(e -> e.compareTo(elementToCompare) > 0)
                .count();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T value : values) {
            sb.append(String.format("%s: %s%n", value.getClass().getName(), value.toString()));
        }
        return sb.toString();
    }

}
