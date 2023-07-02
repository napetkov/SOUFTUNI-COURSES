package entities;

import entities.BaseEntity;
import entities.BillingDetails;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table
public class User extends BaseEntity {
    @Column(name = "first_name",length = 50,nullable = false)
    private String firstName;
    @Column(name = "last_name",length = 50, nullable = false)
    private String lastName;
    @Column(unique = true,nullable = false,length = 100)
    private String email;
    @Column(nullable = false,length = 120)
    private String password;
    @OneToMany(mappedBy = "owner",cascade = CascadeType.ALL)
    private Set<BillingDetails> billingDetails;

}
