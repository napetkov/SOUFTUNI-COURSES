package com.example.myfirstspring;

import com.example.myfirstspring.entities.Student;
import com.example.myfirstspring.services.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private StudentService studentService;

    public ConsoleRunner(StudentService studentService){
        this.studentService = studentService;
    }
    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String studentName = scanner.nextLine();

        Student registeredStudent = studentService.register(studentName);

        Student student = studentService.searchByName(studentName);

        System.out.println(student.getId());

    }
}
