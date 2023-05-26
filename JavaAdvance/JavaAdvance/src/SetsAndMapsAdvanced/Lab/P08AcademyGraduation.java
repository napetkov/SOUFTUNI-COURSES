package SetsAndMapsAdvanced.Lab;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class P08AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbersOfStudents = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> studentsGrade = new TreeMap<>();

        for (int i = 0; i < numbersOfStudents; i++) {

            String nameStudent = scanner.nextLine();

            List<Double> studentsGrades = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .map(Double::parseDouble)
                    .collect(Collectors.toList());

            studentsGrade.put(nameStudent, studentsGrades);
        }
        studentsGrade.forEach((k, v) -> {
            System.out.printf(k + " is graduated with ");
            double sum = 0;
            for (Double e : v) {
                sum += e;
            }
            double average = sum/v.size();
            System.out.println(average);
        });

    }
}
