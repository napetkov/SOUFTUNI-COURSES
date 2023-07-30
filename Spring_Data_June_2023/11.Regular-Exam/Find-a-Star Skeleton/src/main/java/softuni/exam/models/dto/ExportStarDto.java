package softuni.exam.models.dto;

import java.util.Locale;

public class ExportStarDto {

    private String starName;

    private Double lightYears;

    private String description;

    private String constellationName;

    public ExportStarDto() {
    }

    public String getStarName() {
        return starName;
    }

    public void setStarName(String starName) {
        this.starName = starName;
    }

    public Double getLightYears() {
        return lightYears;
    }

    public void setLightYears(Double lightYears) {
        this.lightYears = lightYears;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getConstellationName() {
        return constellationName;
    }

    public void setConstellationName(String constellationName) {
        this.constellationName = constellationName;
    }

    @Override
    public String toString() {
        return String.format(Locale.US,"Star: %s\n   *Distance: %.2f light years\n   **Description: %s\n   ***Constellation: %s\n",
                this.starName,
                this.lightYears,
                this.description,
                this.constellationName);
    }
}
