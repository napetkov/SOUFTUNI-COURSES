package ObjectsAndClasses.Exercises;

import java.util.*;
import java.util.stream.Collectors;

public class P05Students {
    static class Student {
        String firstName;
        String secondName;
        double grade;

        public Student(String firstName,String secondName,double grade){
            this.firstName = firstName;
            this.secondName = secondName;
            this.grade = grade;

        }

        public double getGrade() {
            return grade;
        }

        @Override
        public String toString() {
            return firstName + " " + secondName + ": " + String.format("%.2f",grade);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            int n = Integer.parseInt(scanner.nextLine());

        List<Student> studentsList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String inputFirstName = input.split(" ")[0];
            String inputSecondName = input.split(" ")[1];
            double inputGrade = Double.parseDouble(input.split(" ")[2]);

            Student currentStudent = new Student(inputFirstName,inputSecondName,inputGrade);
            studentsList.add(currentStudent);
        }
        studentsList.sort(Comparator.comparing(Student::getGrade));
        Collections.reverse(studentsList);

            for(Student element:studentsList){
                System.out.println(element.toString());
            }





    }

}
