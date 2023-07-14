package com.example.springjson.services;

import com.example.springjson.dtos.StudentDTO;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl {
    private final Gson gson;

    public StudentServiceImpl(Gson gson) {
        this.gson = gson;
    }

    public void create(String createGson){
        StudentDTO studentDTO = gson.fromJson(createGson, StudentDTO.class);

        System.out.println("Created ->" + studentDTO);

    }

    public String getAllAsJson(){
    return null;
    }

}
