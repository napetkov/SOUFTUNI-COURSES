package StramFilesAndDirectories.Exercises;

import java.io.*;

public class P11SerilizeCustomObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Course course = new Course();
        course.name = "Java Advance September 2022";
        course.numberStudents = 250;

        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Exercises-Resources/courses.ser"));
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("Exercises-Resources/courses.ser"));

        output.writeObject(course);

        Course courseFromFile = (Course)input.readObject();
        System.out.println(courseFromFile.numberStudents);
        System.out.println(courseFromFile.name);

    }

}
