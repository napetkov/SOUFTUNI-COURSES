package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table
public class Patient extends BaseEntity{
    @Column(name = "first_name",nullable = false,length = 50)
    private String firstName;
    @Column(name = "last_name",nullable = false,length = 50)
    private String lastName;
    @Column
    private String address;
    @Column
    private String email;
    @Column
    private Date dateOfBirth;
    @Column
    private String picture;
    @Column(nullable = false)
    private Double isMedicalInsurance;
    @ManyToMany
    @JoinTable(name = "patients_visitations",
    joinColumns = @JoinColumn(name = "patient_id",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "visitation_id",referencedColumnName = "id"))
    private Set<Visitation> visitation;
}

