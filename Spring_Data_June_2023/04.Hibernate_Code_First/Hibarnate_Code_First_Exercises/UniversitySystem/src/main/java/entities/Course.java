package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Course extends BaseEntity{
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private Date startDate;
    @Column
    private String endDate;
    @Column
    private Integer credits;

}
