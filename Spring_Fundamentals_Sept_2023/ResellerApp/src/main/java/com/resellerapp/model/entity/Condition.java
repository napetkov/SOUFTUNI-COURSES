package com.resellerapp.model.entity;

import com.resellerapp.model.enums.ConditionName;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "conditions")
public class Condition extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,unique = true)
    private ConditionName name;
    @NotNull
    @Column(nullable = false)
    private String description;

    public ConditionName getName() {
        return name;
    }

    public Condition setName(ConditionName name) {
        this.name = name;
        this.setDescription(name);
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Condition setDescription(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(ConditionName name){
        String description ="";


        switch (name){
            case GOOD -> description = "In perfect condition";
            case EXCELLENT -> description = "Some signs of wear and tear or minor defects";
            case ACCEPTABLE -> description = "The item is fairly worn but continues to function properly";

        }

        this.description = description;
    }
}
