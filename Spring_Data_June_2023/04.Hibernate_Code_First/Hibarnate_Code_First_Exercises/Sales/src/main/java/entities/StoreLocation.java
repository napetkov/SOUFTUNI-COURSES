package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "store_location")
public class StoreLocation extends BaseEntity{
    @Column
    private String locationName;
    @OneToMany(mappedBy = "storeLocation")
    private Set<Sale> sales;
}
