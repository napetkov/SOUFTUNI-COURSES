package ObjectsAndClasses.Exercises.p02articles;

import org.w3c.dom.ls.LSOutput;

public class Articles {
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
