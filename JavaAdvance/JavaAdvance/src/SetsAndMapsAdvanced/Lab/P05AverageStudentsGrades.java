package SetsAndMapsAdvanced.Lab;

import com.sun.source.tree.Tree;

import java.util.*;

public class P05AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbersOfStudents = Integer.parseInt(scanner.nextLine());

        TreeMap<String, List<Double>> studentsBayGrade = new TreeMap<>();

        for (int i = 0; i < numbersOfStudents; i++) {
            String input = scanner.nextLine();

            String studentName = input.split("\\s+")[0];
            double grade = Double.parseDouble(input.split("\\s+")[1]);

                if (studentsBayGrade.containsKey(studentName)) {
                    studentsBayGrade.get(studentName).add(grade);

                } else {
                    studentsBayGrade.put(studentName, new ArrayList<>());
                    studentsBayGrade.get(studentName).add(grade);
                }


        }

        for (Map.Entry<String, List<Double>> entry : studentsBayGrade.entrySet()) {
            String name = entry.getKey();
            List<Double> grade = entry.getValue();
//            STREAM API - Judge -> 90/100.Way?
//            double average = grade.stream().mapToDouble(a -> a)
//                    .average()
//                    .orElse(0);
            double sum = 0;
            for (Double aDouble : grade) {
                sum += aDouble;
            }
            double average = sum/ grade.size();
            System.out.print(name + " -> ");
            grade.forEach(element -> System.out.printf("%.2f ", element));
            System.out.printf("(avg: %.2f)%n", average);
        }

    }
}
