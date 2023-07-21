package softuni.exam.models.dto;

import softuni.exam.models.entity.Country;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class CityImportDto {
    @NotNull
    @Size(min = 2, max = 60)
    private String cityName;
    @NotNull
    @Size(min = 2)
    private String description;
    @NotNull
    @Min(value = 500)
    @Positive
    private Integer population;
    @NotNull
    @Positive
    private Long country;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }
    public Long getCountry() {
        return country;
    }

    public void setCountry(Long country) {
        this.country = country;
    }
}
