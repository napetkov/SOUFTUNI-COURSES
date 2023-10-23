package com.dictionaryapp.model.dto.word;

import com.dictionaryapp.model.entity.Word;
import jakarta.persistence.Column;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

public class WordDTO {
    private long id;
    private String term;
    private String translation;
    private String example;
    private String inputDate;
    private String addedByUsername;

    public long getId() {
        return id;
    }

    public WordDTO setId(long id) {
        this.id = id;
        return this;
    }

    public String getTerm() {
        return term;
    }

    public WordDTO setTerm(String term) {
        this.term = term;
        return this;
    }

    public String getTranslation() {
        return translation;
    }

    public WordDTO setTranslation(String translation) {
        this.translation = translation;
        return this;
    }

    public String getExample() {
        return example;
    }

    public WordDTO setExample(String example) {
        this.example = example;
        return this;
    }

    public String getInputDate() {
        return inputDate;
    }

    public WordDTO setInputDate(String inputDate) {
        this.inputDate = inputDate;
        return this;
    }

    public String getAddedByUsername() {
        return addedByUsername;
    }

    public WordDTO setAddedByUsername(String addedByUsername) {
        this.addedByUsername = addedByUsername;
        return this;
    }

    public static WordDTO createFromWordEntity(Word word){
        return new WordDTO()
                .setTerm(word.getTerm())
                .setTranslation(word.getTranslation())
                .setExample(word.getExample())
                .setInputDate(word.getInputDate().toString())
                .setAddedByUsername(word.getAddedBy().getUsername())
                .setId(word.getId());
    }
}
