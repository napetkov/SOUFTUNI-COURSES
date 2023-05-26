package Generics.Exercises.CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CustomList<T extends Comparable<T>> {

    private List<T> values;

    public CustomList() {
        values = new ArrayList<>();
    }

    public void add(T element){
        values.add(element);
    }

    public void remove(int index){
        values.remove(index);
    }
    public void contains(T element){
        System.out.println(values.contains(element));
    }
    public void swap(int firstIndex,int secondIndex){
        T firstElement = values.get(firstIndex);
        values.set(firstIndex,values.get(secondIndex));
        values.set(secondIndex,firstElement);
    }
    public void countGreaterElements(T element){
        int countOfGreaterElements = (int)values.stream()
                .filter( elementToCompare -> elementToCompare.compareTo(element)>0)
                .count();
        System.out.println(countOfGreaterElements);

    }
    public void max(){
        System.out.println(values.stream().max(Comparable::compareTo).get());
    }
    public void min(){
        System.out.println(values.stream().min(Comparable::compareTo).get());
    }
    public void print(){
        values.forEach(System.out::println);
    }
    public int size(){
        return values.size();
    }
    public T get(int index){
        return values.get(index);
    }


}
