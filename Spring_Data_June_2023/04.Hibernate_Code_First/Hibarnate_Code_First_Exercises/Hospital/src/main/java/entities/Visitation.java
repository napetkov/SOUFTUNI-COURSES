package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table
public class Visitation extends BaseEntity{
    @Column(nullable = false)
    private Date dateOfVisitation;
    @Column(columnDefinition = "TEXT")
    private String comment;
    @OneToOne
    @JoinColumn
    private Diagnose diagnose;
}

