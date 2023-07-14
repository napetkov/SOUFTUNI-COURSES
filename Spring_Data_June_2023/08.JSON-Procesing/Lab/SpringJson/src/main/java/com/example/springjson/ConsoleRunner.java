package com.example.springjson;

import com.example.springjson.dtos.StudentDTO;
import com.example.springjson.services.CourseServiceImpl;
import com.example.springjson.services.StudentServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private StudentServiceImpl studentService;
    private CourseServiceImpl courseService;

    public ConsoleRunner(StudentServiceImpl studentService, CourseServiceImpl courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    @Override
    public void run(String... args) throws Exception {

        StudentDTO studentDTO = new StudentDTO(
                "First",
                22,
                false,
                List.of("Math", "Biology"));

        String stringJson = """
                {
                  "firstName": "First",
                  "age": 22,
                  "isGraduated": false,
                  "coursesTaken": ["Math","Biology"]
                }
                """;
        studentService.create(stringJson);

        String courseJson = """
                {
                    "name" : "Math",
                    "lengthInWeeks" : "12"
                }
                """;
        courseService.createCourse(courseJson);


    }
}
