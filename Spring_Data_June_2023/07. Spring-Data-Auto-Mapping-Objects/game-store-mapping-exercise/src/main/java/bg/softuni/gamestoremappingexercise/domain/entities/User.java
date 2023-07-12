package bg.softuni.gamestoremappingexercise.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity{

    @Column(nullable = false, unique = true)
    @Email
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(name = "full_name",length = 50)
    private String fullName;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Game> games;

    @OneToMany(targetEntity = Order.class, mappedBy = "user",fetch = FetchType.EAGER)
    private Set<Order> orders;

    @Column(nullable = false)
    private Boolean isAdmin;
}
