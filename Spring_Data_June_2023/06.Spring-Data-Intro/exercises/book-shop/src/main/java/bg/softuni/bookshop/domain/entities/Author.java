package bg.softuni.bookshop.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "authors")
public class Author extends BaseEntity{
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name",nullable = false)
    private String lastName;

    @OneToMany(targetEntity = Book.class, mappedBy = "author", fetch = FetchType.EAGER)
       private List<Book> books;

    public String getAuthorFullName(){
        return this.firstName + " " + this.lastName;
    }

    public String getAuthorFullNameAndBookCount(){
        return this.firstName + " " + this.lastName + " " + this.books.size();
    }
}
