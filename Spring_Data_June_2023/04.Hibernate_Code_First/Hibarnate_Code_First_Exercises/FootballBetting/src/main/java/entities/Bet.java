package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Entity
@Table
public class Bet extends BaseEntity{

    @Column(name = "bet_money")
    private BigDecimal betMoney;

    @Column
    private Date timeOfBet;

    @ManyToOne
    private User user;

}
