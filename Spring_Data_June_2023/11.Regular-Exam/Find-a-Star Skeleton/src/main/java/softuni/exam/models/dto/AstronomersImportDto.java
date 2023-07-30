package softuni.exam.models.dto;

import softuni.exam.models.entity.Star;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

@XmlRootElement(name = "astronomer")
@XmlAccessorType(XmlAccessType.FIELD)
public class AstronomersImportDto {

    @NotNull
    @Size(min = 2,max = 30)
    @XmlElement(name = "first_name")
    private String firstName;

    @NotNull
    @Size(min = 2,max = 30)
    @XmlElement(name = "last_name")
    private String lastName;

    @NotNull
    @DecimalMin(value = "15000.00")
    @XmlElement
    private Double salary;

    @NotNull
    @DecimalMin(value = "500.00")
    @XmlElement(name = "average_observation_hours")
    private Double averageObservationHours;

    @XmlElement
    private String birthday;
    @NotNull
    @XmlElement(name = "observing_star_id")
    private long starId;

    public AstronomersImportDto() {
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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getAverageObservationHours() {
        return averageObservationHours;
    }

    public void setAverageObservationHours(Double averageObservationHours) {
        this.averageObservationHours = averageObservationHours;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public long getStarId() {
        return starId;
    }

    public void setStarId(long starId) {
        this.starId = starId;
    }
}
