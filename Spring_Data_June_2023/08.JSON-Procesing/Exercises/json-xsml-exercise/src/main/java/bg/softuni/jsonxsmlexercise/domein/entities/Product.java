package bg.softuni.jsonxsmlexercise.domein.entities;

import bg.softuni.jsonxsmlexercise.domein.models.ProductDTO;
import bg.softuni.jsonxsmlexercise.domein.models.ProductSoldWithCountDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product extends BaseEntity{
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.EAGER)
//    @Fetch(FetchMode.JOIN)
    private User buyer;

    @ManyToOne
    private User seller;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Category> categories;


}
