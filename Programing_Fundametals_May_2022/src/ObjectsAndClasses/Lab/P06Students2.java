package ObjectsAndClasses.Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P06Students2 {

    static class Students{
        String firstName;
        String lastName;
        String age;
        String homeTown;

        public Students(String firstName,String lastName,String age,String homeTown){
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.homeTown = homeTown;
        }

        public String getFirstName() {
            return this.firstName;
        }

        public String getLastName() {
            return this.lastName;
        }

        public String getAge() {
            return this.age;
        }

        public String getHomeTown() {
            return this.homeTown;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Students> listOfStudents =new ArrayList<>();
        while(!input.equals("end")){
            String[] inputStudentArr = input.split(" ");
            String inputFirstName = inputStudentArr[0];
            String inputLastName = inputStudentArr[1];
            String inputAge = inputStudentArr[2];
            String inputHomeTown = inputStudentArr[3];

            Students currentStudent = new Students(inputFirstName,inputLastName,inputAge,inputHomeTown);

            //isExistObject?? by fisrtName & lastName
            if(isExistStudents(listOfStudents,inputFirstName,inputLastName)){
                listOfStudents.removeIf(item -> item.getFirstName().equals(inputFirstName) && item.getLastName().equals(inputLastName));
            }

            listOfStudents.add(currentStudent);

            input = scanner.nextLine();
        }
        String searchTown = scanner.nextLine();

        for(Students item:listOfStudents){
            if(item.getHomeTown().equals(searchTown)){

                System.out.printf("%s %s is %s years old%n",item.getFirstName(),item.getLastName(),item.getAge());
            }

        }

    }

    private static boolean isExistStudents(List<Students> listOfStudents, String inputFirstName, String inputLastName) {
        for(Students item:listOfStudents){
            if(item.getFirstName().equals(inputFirstName)&&item.getLastName().equals(inputLastName)){
                return true;
            }
        }
        return false;
    }


}
