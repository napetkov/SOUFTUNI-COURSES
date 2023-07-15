package bg.softuni.jsonxsmlexercise.domein.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "categories")
public class Category extends BaseEntity{

    @Column(nullable = false,length = 15)
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        return Objects.equals(name, category.name) &&
                Objects.equals(getId(),category.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, getId());
    }
}
