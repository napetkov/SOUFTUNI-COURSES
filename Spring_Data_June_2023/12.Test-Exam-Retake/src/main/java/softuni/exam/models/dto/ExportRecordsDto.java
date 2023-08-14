package softuni.exam.models.dto;

import java.time.LocalDate;

public class ExportRecordsDto {
    private String bookTitle;
    private String bookAuthor;
    private String borrowDate;
    private String libraryMemberFirstName;
    private String libraryMemberLastName;

    public ExportRecordsDto() {
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getLibraryMemberFirstName() {
        return libraryMemberFirstName;
    }

    public void setLibraryMemberFirstName(String libraryMemberFirstName) {
        this.libraryMemberFirstName = libraryMemberFirstName;
    }

    public String getLibraryMemberLastName() {
        return libraryMemberLastName;
    }

    public void setLibraryMemberLastName(String libraryMemberLastName) {
        this.libraryMemberLastName = libraryMemberLastName;
    }

    @Override
    public String toString() {
        return String.format("Book title: %s\n*Book author: %s\n**Date borrowed: %s\n***Borrowed by: %s %s\n",
                this.bookTitle,
                this.bookAuthor,
                this.borrowDate,
                this.libraryMemberFirstName,
                this.libraryMemberLastName);
    }
}
