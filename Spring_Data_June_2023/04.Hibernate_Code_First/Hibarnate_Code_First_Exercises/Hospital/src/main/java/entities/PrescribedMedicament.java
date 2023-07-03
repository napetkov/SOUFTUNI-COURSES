package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "prescribed_medicaments")
public class PrescribedMedicament extends BaseEntity{
    @Column(length = 50,nullable = false)
    private String name;
}
