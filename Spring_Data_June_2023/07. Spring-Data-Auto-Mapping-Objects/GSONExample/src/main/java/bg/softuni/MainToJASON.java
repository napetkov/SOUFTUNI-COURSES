package bg.softuni;

import bg.softuni.dtos.CourseDTO;
import bg.softuni.dtos.StudentAdditionalInfoDTO;
import bg.softuni.dtos.StudentDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

public class MainToJASON {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .serializeNulls()
                .setPrettyPrinting()
                .create();

        StudentDTO studentDTO = new StudentDTO(
                "First",
                null,
                22,
                new StudentAdditionalInfoDTO(false,5.38),
                List.of(
                new CourseDTO("Math", 4),
                new CourseDTO("Biology", 5)));

        String json = gson.toJson(studentDTO);

        System.out.println(json);


//        List<StudentDTO> studentDTOList = List.of(studentDTO);
//
//        String jsonList = gson.toJson(studentDTOList);
//
//        System.out.println(jsonList);
//
//        Map<String, String> map = new HashMap<>();
//        map.put("first", "f");
//        map.put("second", "s");
//        map.put("third", "t");
//
//        String jsonMap = gson.toJson(map);
//
//        System.out.println(jsonMap);


    }
}