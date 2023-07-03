package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table
public class Diagnose extends BaseEntity {
    @Column(nullable = false,length = 50)
    private String name;
    @Column(columnDefinition = "TEXT")
    private String comment;
    @OneToMany
    @JoinColumn
    private Set<PrescribedMedicament> medicament;
}

