package org.softuni.pathfinder.models;

import jakarta.persistence.*;
import org.softuni.pathfinder.models.enums.UserRoles;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity{

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private UserRoles name;

    public Role() {
    }

    public UserRoles getName() {
        return name;
    }

    public void setName(UserRoles name) {
        this.name = name;
    }
}
