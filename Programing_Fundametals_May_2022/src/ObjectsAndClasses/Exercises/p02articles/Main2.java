package ObjectsAndClasses.Exercises.p02articles;

import java.util.*;
import java.util.stream.Collectors;

public class Main2 {
    static class Articles {
        //характеристики -> полета;
        private String title;
        private String content;
        private String author;

        //консатруктор -> създаваме обекти от този клас;
        public Articles(String title, String content, String author) {
            //нов обект
            this.title = title;
            this.content = content;
            this.author = author;
        }

        public String getTitle() {
            return this.title;
        }

        public String getContent() {
            return this.content;

        }

        public String getAuthor() {
            return this.author;
        }

        //функционалности -> методи;
        public void edit(String newContent) {
            this.content = newContent;
        }

        public void changeAuthor(String newAuthor) {
            this.author = newAuthor;
        }

        public void rename(String newTitle) {
            this.title = newTitle;
        }

        @Override //така пренаписваме метода да работи по мой избор
        public String toString() {
            return this.title + " - " + this.content + ": " + this.author;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Articles> newArticlesList = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String input = scanner.nextLine();

            String title = input.split(", ")[0];
            String content = input.split(", ")[1];
            String author = input.split(", ")[2];

            Articles currentArticle = new Articles(title,content,author);
            newArticlesList.add(currentArticle);
        }
        String inputs = scanner.nextLine();

        for (Articles element:newArticlesList) {
            System.out.println(element.getTitle() + " - " + element.getContent() + ": "+element.getAuthor());
    }

//        newArticlesList.sort(Comparator.comparing(Articles::getContent));
//        System.out.println(newArticlesList.toString());

    }
}
