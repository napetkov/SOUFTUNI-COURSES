package WhileLoop.Exercises;

import java.util.Scanner;

public class OldBooks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String wantedBook = scanner.nextLine();

        String bookName = scanner.nextLine();
        int countBooks = 0;
        boolean isFound = false;
        while(!bookName.equals("No More Books")){
                if(bookName.equals(wantedBook)){
                    isFound = true;
                    break;
                }else{
                    bookName = scanner.nextLine();
                }
            countBooks++;
        }
        if(isFound){
            System.out.printf("You checked %d books and found it.",countBooks);
        }else{

            System.out.println("The book you search is not here!");
            System.out.printf("You checked %d books.",countBooks);
        }

    }
}
