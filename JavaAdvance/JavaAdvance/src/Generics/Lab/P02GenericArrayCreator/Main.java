package Generics.Lab.P02GenericArrayCreator;

public class Main {

    public static void main(String[] args) {

        Integer [] arr = ArrayCreator.create(Integer.class,5,13);

        for (int i : arr) {
            System.out.print(i + " ");

        }
        String [] str = ArrayCreator.create(5,"Nik");

        for (String s : str) {
            System.out.print(s + " ");
        }
    }
}
