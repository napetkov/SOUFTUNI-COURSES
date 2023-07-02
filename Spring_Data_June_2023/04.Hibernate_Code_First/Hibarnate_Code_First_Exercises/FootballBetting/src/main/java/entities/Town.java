package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
public class Town extends BaseEntity{
    @Column(nullable = false)
    private String name;

    @ManyToOne
    private Country country;
}
