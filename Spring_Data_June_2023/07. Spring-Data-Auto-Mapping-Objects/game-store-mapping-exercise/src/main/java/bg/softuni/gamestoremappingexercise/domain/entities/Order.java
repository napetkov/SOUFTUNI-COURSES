package bg.softuni.gamestoremappingexercise.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order extends BaseEntity{
    @ManyToOne
    private User user;

    @ManyToMany(targetEntity = Game.class,fetch = FetchType.EAGER)
    private List<Game> games;


}
