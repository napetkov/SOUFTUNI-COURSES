package com.example.football.models.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "player")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlayerImportDto {

    @XmlElement(name = "first-name")
    @Size(min = 2)
    @NotNull
    private String firstName;
    @XmlElement(name = "last-name")
    @Size(min = 2)
    @NotNull
    private String lastName;

    @XmlElement
    @Email
    @NotNull
    private String email;

    @XmlElement(name = "birth-date")
    @NotNull
    private String birthDate;

    @XmlElement
    @NotNull
    @Enumerated(EnumType.STRING)
    private String position;

    @XmlElement
    private BaseTownDto town;

    @XmlElement
    private BaseTeamDto team;

    @XmlElement
    private BaseStatDto stat;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public BaseTownDto getTown() {
        return town;
    }

    public void setTown(BaseTownDto town) {
        this.town = town;
    }

    public BaseTeamDto getTeam() {
        return team;
    }

    public void setTeam(BaseTeamDto team) {
        this.team = team;
    }

    public BaseStatDto getStat() {
        return stat;
    }

    public void setStat(BaseStatDto stat) {
        this.stat = stat;
    }
}
