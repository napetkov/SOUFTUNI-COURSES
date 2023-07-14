package bg.softuni.dtos;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class CourseDTO implements Serializable {
    @Expose
    private String name;

    @Expose
    private int lengthInWeeks;

    @Expose
    private Date createdAt;

    public CourseDTO(String name, int lengthInWeeks, Date createdAt) {
        this.name = name;
        this.lengthInWeeks = lengthInWeeks;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "CourseDTO{" +
                "name='" + name + '\'' +
                ", lengthInWeeks=" + lengthInWeeks +
                ", createdAt=" + createdAt  +
                '}';
    }
}
