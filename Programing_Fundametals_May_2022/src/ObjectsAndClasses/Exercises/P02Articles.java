package ObjectsAndClasses.Exercises;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02Articles {

    static class Articles {

        String title;
        String content;
        String author;

        public Articles(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public String getContent() {
            return content;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> inputArticlesList = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());
        int n = Integer.parseInt(scanner.nextLine());


        for (int i = 0; i < n; i++) {
            String[] commandLineArr = scanner.nextLine().split(" ");
            String command = commandLineArr[0];


        }


    }
}
