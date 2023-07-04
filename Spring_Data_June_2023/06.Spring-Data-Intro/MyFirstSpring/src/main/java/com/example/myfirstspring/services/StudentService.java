package com.example.myfirstspring.services;

import com.example.myfirstspring.entities.Student;

public interface StudentService {
    Student register(String name);

    Student searchByName(String name);
}
