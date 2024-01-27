package com.resellerapp.model.entity;

import com.resellerapp.model.enums.ConditionName;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "conditions")
public class Condition extends BaseEntity {
    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private ConditionName name;
    @Column(nullable = false)
    private String description;
    @OneToMany(mappedBy = "condition")
    private Set<Offer> offers;


    public void setDescription(ConditionName name) {
        String description = "";
        switch (name) {
            case GOOD -> description = "Some signs of wear and tear or minor defects";
            case EXCELLENT  -> description = "In perfect condition";
            case ACCEPTABLE  -> description = "The item is fairly worn but continues to function properly";
        }


        this.description = description;
    }

    public ConditionName getName() {
        return name;
    }

    public Condition setName(ConditionName name) {
        this.name = name;
        setDescription(name);
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Condition setDescription(String description) {
        this.description = description;
        return this;
    }

    public Set<Offer> getOffers() {
        return offers;
    }

    public Condition setOffers(Set<Offer> offers) {
        this.offers = offers;
        return this;
    }
}
