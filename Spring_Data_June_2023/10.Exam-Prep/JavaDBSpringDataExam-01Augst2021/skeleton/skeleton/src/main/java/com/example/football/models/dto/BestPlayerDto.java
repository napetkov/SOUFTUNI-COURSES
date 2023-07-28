package com.example.football.models.dto;

public class BestPlayerDto {
    private String firstName;
    private String lastName;

    private String position;

    private String teamName;

    private String teamStadiumName;

    public BestPlayerDto() {
    }
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamStadiumName() {
        return teamStadiumName;
    }

    public void setTeamStadiumName(String teamStadiumName) {
        this.teamStadiumName = teamStadiumName;
    }

       @Override
    public String toString() {
        return String.format("\"Player - %s %s\n\tPosition - %s\n\tTeam - %s\n\tStadium - %s\n. . . \n",
                this.firstName,
                this.lastName,
                this.position,
                this.teamName,
                this.teamStadiumName);
    }
}
