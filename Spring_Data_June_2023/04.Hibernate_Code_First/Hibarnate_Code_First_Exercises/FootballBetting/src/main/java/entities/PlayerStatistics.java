package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "player_statistics")
public class PlayerStatistics implements Serializable {
//    Game, Player, Scored Goals, Player Assists, Played Minutes During Game, (PK = Game + Player)
    @Id
    @ManyToOne
    @JoinColumn
    private Game game;

    @Id
    @ManyToOne
    @JoinColumn
    private Player player;

    @Column
    private Short scoredGoals;

    @Column
    private Short playerAssists;

    @Column
    private Short playedMinutesDuringGame;
}

