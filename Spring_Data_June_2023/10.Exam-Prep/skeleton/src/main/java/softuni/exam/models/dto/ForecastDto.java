package softuni.exam.models.dto;

import softuni.exam.models.entity.City;
import softuni.exam.models.entity.DayOfWeek;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.validation.constraints.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalTime;

@XmlRootElement(name = "forecast")
@XmlAccessorType(XmlAccessType.FIELD)
public class ForecastDto {

    @NotNull
    @XmlElement(name = "day_of_week")
    private String dayOfWeek;

    @NotNull
    @DecimalMin(value = "-20.00")
    @DecimalMax(value = "60.00")
    @XmlElement(name = "max_temperature")
    private Double maxTemperature;

    @NotNull
    @DecimalMin(value = "-50.00")
    @DecimalMax(value = "40.00")
    @XmlElement(name = "min_temperature")
    private Double minTemperature;

    @NotNull
    @XmlElement
    private String sunrise;

    @NotNull
    @XmlElement
    private String sunset;

    @XmlElement
    private Long city;

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(Double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public Double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(Double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public Long getCity() {
        return city;
    }

    public void setCity(Long city) {
        this.city = city;
    }
}
