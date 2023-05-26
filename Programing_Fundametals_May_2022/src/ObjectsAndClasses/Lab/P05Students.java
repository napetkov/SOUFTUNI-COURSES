package ObjectsAndClasses.Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P05Students {
    static class Students{

        String firstName;
        String lastName;
        String age;
        String homeTown;

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getFirstName() {
            return this.firstName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getLastName() {
            return this.lastName;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getAge() {
            return this.age;
        }

        public void setHomeTown(String homeTown) {
            this.homeTown = homeTown;
        }

        public String getHomeTown() {
            return this.homeTown;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input= scanner.nextLine();

        List<Students> listOfStudents = new ArrayList<>();
        while(!input.equals("end")){

            String[] inputStudentArr = input.split(" ");
            String inputFirstName = inputStudentArr[0];
            String inputLastName = inputStudentArr[1];
            String inputAge = inputStudentArr[2];
            String inputHomeTown = inputStudentArr[3];

            Students currentStudent = new Students();

            currentStudent.setFirstName(inputFirstName);
            currentStudent.setLastName(inputLastName);
            currentStudent.setAge(inputAge);
            currentStudent.setHomeTown(inputHomeTown);

           listOfStudents.add(currentStudent);

            input = scanner.nextLine();
        }
        String commandCity = scanner.nextLine();

        for(Students item:listOfStudents){
            if(item.getHomeTown().equals(commandCity)){
                System.out.printf("%s %s is %s years old%n",item.getFirstName(),item.getLastName(),item.getAge());
            }
        }
    }

}
