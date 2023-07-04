package com.example.myfirstspring.repositories;

import com.example.myfirstspring.entities.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
    Student findByName(String name);
}
