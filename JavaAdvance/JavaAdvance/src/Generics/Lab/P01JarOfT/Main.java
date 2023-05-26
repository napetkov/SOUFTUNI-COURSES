package Generics.Lab.P01JarOfT;

public class Main {
    public static void main(String[] args) {


        Jar<String> jarString = new Jar<>();


        jarString.add("Gosho");
        jarString.add("Misho");
        jarString.remove();

        Jar<Integer> jarIntegers = new Jar<>();

        jarIntegers.add(13);



    }

}
