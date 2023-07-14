package bg.softuni;

import bg.softuni.dtos.StudentAdditionalInfoDTO;
import bg.softuni.dtos.StudentDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainFromJSON {
    public static void main(String[] args) {

        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .serializeNulls()
                .setPrettyPrinting()
                .create();


        String json = "{\"isGraduated\": false,\"averageGrade\": 5.38}";
        String notFormatted = """
                {
                    "isGraduated": false,
                    "averageGrade": 5.38
                  }
                """;

        String studentJson = """
                {
                  "firstName": "First",
                  "lastName": null,
                  "age": 22,
                  "studentAdditionalInfoDto": {
                    "isGraduated": false,
                    "averageGrade": 5.38
                  },
                  "courses": [
                    {
                      "name": "Math",
                      "lengthInWeeks": 4
                    },
                    {
                      "name": "Biology",
                      "lengthInWeeks": 5
                    }
                  ]
                }                
                """;

        StudentAdditionalInfoDTO studentAdditionalInfoDTO = gson.fromJson(json, StudentAdditionalInfoDTO.class);

        StudentAdditionalInfoDTO studentAdditionalInfoDTO2 = gson.fromJson(notFormatted, StudentAdditionalInfoDTO.class);

        StudentDTO studentDTO = gson.fromJson(studentJson, StudentDTO.class);

        System.out.println(studentAdditionalInfoDTO);
        System.out.println(studentAdditionalInfoDTO2);
        System.out.println(studentDTO);



    }
}
