package bg.softuni.bookservice.model.dto;

import bg.softuni.bookservice.model.entity.BookEntity;
import jakarta.persistence.OneToMany;

import java.util.List;

public class AuthorDTO {
    private String name;

    public String getName() {
        return name;
    }

    public AuthorDTO setName(String name) {
        this.name = name;
        return this;
    }
}
