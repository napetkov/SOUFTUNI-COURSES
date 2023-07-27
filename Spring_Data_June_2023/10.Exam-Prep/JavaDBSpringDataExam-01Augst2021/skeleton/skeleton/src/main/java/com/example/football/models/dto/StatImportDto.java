package com.example.football.models.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "stat")
@XmlAccessorType(XmlAccessType.FIELD)
public class StatImportDto {

    @NotNull
    @DecimalMin(value = "0.00")
    @XmlElement(name = "passing")
    private Float passing;
    @NotNull
    @DecimalMin(value = "0.00")
    @XmlElement(name = "shooting")
    private Float shooting;
    @NotNull
    @DecimalMin(value = "0.00")
    @XmlElement(name = "endurance")
    private Float endurance;

    public Float getPassing() {
        return passing;
    }

    public void setPassing(Float passing) {
        this.passing = passing;
    }

    public Float getShooting() {
        return shooting;
    }

    public void setShooting(Float shooting) {
        this.shooting = shooting;
    }

    public Float getEndurance() {
        return endurance;
    }

    public void setEndurance(Float endurance) {
        this.endurance = endurance;
    }
}
