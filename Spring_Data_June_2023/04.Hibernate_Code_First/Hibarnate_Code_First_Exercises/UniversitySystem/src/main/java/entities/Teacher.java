package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Teacher extends BaseEntity{
    @Column(name = "first_name",nullable = false)
    private String firstName;
    @Column(name = "last_name",nullable = false)
    private String lastName;
    @Column
    private String phoneNumber;
    @Column
    private String email;
    @Column(nullable = false)
    private BigDecimal salaryPerHour;
    @OneToMany
    private List<Course> courses;
}

