package org.softuni.mobilele.model.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Entity
@Table(name = "brands")
@NamedEntityGraph(
        name = "brandWithModels",
        attributeNodes = @NamedAttributeNode("models")
)
public class BrandEntity extends BaseEntity {
    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany
            (fetch = FetchType.LAZY,
                    mappedBy = "brand")
//    @Fetch(value = FetchMode.SUBSELECT)
    private List<ModelEntity> models;

    public String getName() {
        return name;
    }

    public BrandEntity setName(String name) {
        this.name = name;
        return this;
    }

    public List<ModelEntity> getModels() {
        return models;
    }

    public BrandEntity setModels(List<ModelEntity> models) {
        this.models = models;
        return this;
    }
}


