package bg.softuni.dtos;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class StudentAdditionalInfoDTO implements Serializable {
    @Expose
    private boolean isGraduated;
    @Expose
    private double averageGrade;

    public StudentAdditionalInfoDTO(boolean isGraduated, double averageGrade) {
        this.isGraduated = isGraduated;
        this.averageGrade = averageGrade;
    }

    @Override
    public String toString() {
        return "StudentAdditionalInfoDTO{" +
                "isGraduated=" + isGraduated +
                ", averageGrade=" + averageGrade +
                '}';
    }
}
