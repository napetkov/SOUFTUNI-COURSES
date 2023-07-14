package bg.softuni;

import bg.softuni.dtos.CourseDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

public class MainDates {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setDateFormat("dd-MMM-yyyy")
                .setPrettyPrinting()
                .create();


        CourseDTO math = new CourseDTO("Math", 10, Date.from(Instant.now()));

        String mathJson = """
                {
                  "name": "Math",
                  "lengthInWeeks": 10,
                  "createdAt": "14-Jul-2023"
                }
                """;


        System.out.println(gson.toJson(math));

        System.out.println(gson.fromJson(mathJson,CourseDTO.class));
    }
}
