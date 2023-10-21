package com.likebookapp.model.dto.post;

import com.likebookapp.model.enums.MoodName;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PostAddBindingModel {
    @NotNull
    @Size(min = 2, max = 50,message = "Content length must be between 2 and 50 characters!")
    private String content;
    @NotNull(message = "You must select a mood!")
    private MoodName mood;

    public String getContent() {
        return content;
    }

    public PostAddBindingModel setContent(String content) {
        this.content = content;
        return this;
    }

    public MoodName getMood() {
        return mood;
    }

    public PostAddBindingModel setMood(MoodName mood) {
        this.mood = mood;
        return this;
    }
}
