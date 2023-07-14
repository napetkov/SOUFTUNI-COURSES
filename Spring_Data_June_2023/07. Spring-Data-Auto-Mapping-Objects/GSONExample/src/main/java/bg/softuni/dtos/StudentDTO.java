package bg.softuni.dtos;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.List;

public class StudentDTO implements Serializable {
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private int age;
    @Expose
    private StudentAdditionalInfoDTO studentAdditionalInfoDto;

    @Expose
    private List<CourseDTO> courses;

    public StudentDTO(String firstName, String lastName, int age, StudentAdditionalInfoDTO studentAdditionalInfoDto, List<CourseDTO> coursesTaken) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.studentAdditionalInfoDto = studentAdditionalInfoDto;
        this.courses = coursesTaken;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", studentAdditionalInfoDto=" + studentAdditionalInfoDto +
                ", courses=" + courses +
                '}';
    }
}
