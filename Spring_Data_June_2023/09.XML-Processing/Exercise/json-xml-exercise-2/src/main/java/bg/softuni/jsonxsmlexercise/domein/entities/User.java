package bg.softuni.jsonxsmlexercise.domein.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends BaseEntity{
    @Column(name = "firas_name")
    private String firstName;

    @Column(name = "last_name)",nullable = false)
    private String lastName;

    @Column
    private Long age;

    @OneToMany(targetEntity = Product.class,mappedBy = "seller",fetch = FetchType.EAGER)
    private Set<Product> sellingProducts;

    @OneToMany(targetEntity = Product.class,mappedBy = "buyer",fetch = FetchType.EAGER)
    private Set<Product> boughtProducts;

    @ManyToMany
    private Set<User> friends;


}
