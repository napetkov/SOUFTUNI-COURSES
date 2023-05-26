package CollectionHierarchy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyList myList = new MyListImpl();

        String[] words = scanner.nextLine().split("\\s+");
        int removeOperation = Integer.parseInt(scanner.nextLine());

        performAddOperations(words,addCollection);
        performAddOperations(words,addRemoveCollection);
        performAddOperations(words,myList);

        performRemoveOperation(removeOperation,addRemoveCollection);
        performRemoveOperation(removeOperation,myList);


    }

    public static void performRemoveOperation(int counter, AddRemovable addRemovable){
        for (int i = 0; i < counter; i++) {
            System.out.print(addRemovable.remove()+ " ");
        }
        System.out.println();
    }

    public static void performAddOperations(String[] words,Addable addable){
        for (String word : words) {
            System.out.print(addable.add(word)+" ");
        }
        System.out.println();
    }
}
