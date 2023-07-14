package bg.softuni.dtos;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class CourseDTO implements Serializable {
    @Expose
    private String name;

    @Expose
    private int lengthInWeeks;

    public CourseDTO(String name, int lengthInWeeks) {
        this.name = name;
        this.lengthInWeeks = lengthInWeeks;
    }

    @Override
    public String toString() {
        return "CourseDTO{" +
                "name='" + name + '\'' +
                ", lengthInWeeks=" + lengthInWeeks +
                '}';
    }
}
