package com.dictionaryapp.model.dto.word;

import com.dictionaryapp.model.enums.LanguageName;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

public class WordAddBindingModel {
    @Size(min = 2,max = 40,message = "Term length must be between 2 and 40 characters!")
    private String term;
    @Size(min = 2,max = 80,message = "Translation length must be between 2 and 80 characters!")
    private String translation;
    @Size(min = 2,max = 200,message = "Description length must be between 2 and 200 characters!")
    private String example;
    @NotNull(message = "The input Date must be in the past or present!")
    @PastOrPresent(message = "The input Date must be in the past or present!")
    private LocalDate inputDate;
    @NotNull(message = "You must select a language!")
    private LanguageName language;

    public String getTerm() {
        return term;
    }

    public WordAddBindingModel setTerm(String term) {
        this.term = term;
        return this;
    }

    public String getTranslation() {
        return translation;
    }

    public WordAddBindingModel setTranslation(String translation) {
        this.translation = translation;
        return this;
    }

    public String getExample() {
        return example;
    }

    public WordAddBindingModel setExample(String example) {
        this.example = example;
        return this;
    }

    public LocalDate getInputDate() {
        return inputDate;
    }

    public WordAddBindingModel setInputDate(LocalDate inputDate) {
        this.inputDate = inputDate;
        return this;
    }

    public LanguageName getLanguage() {
        return language;
    }

    public WordAddBindingModel setLanguage(LanguageName language) {
        this.language = language;
        return this;
    }
}
