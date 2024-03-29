package com.example.football.service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;

//ToDo - Implement all methods
public interface StatService {
    boolean areImported();

    String readStatsFileContent() throws JAXBException, IOException;

    String importStats() throws JAXBException, FileNotFoundException;

}
