package com.dictionaryapp.model.dto.word;

import java.util.ArrayList;
import java.util.List;

public class WordHomeViewModel {
    List<WordDTO> germanWords;
    List<WordDTO> spanishWords;
    List<WordDTO> frenchWords;
    List<WordDTO> italianWords;
    int countOfAllWords;



    public WordHomeViewModel() {
        this(new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
    }

    public WordHomeViewModel(List<WordDTO> germanWords, List<WordDTO> spanishWords, List<WordDTO> frenchWords, List<WordDTO> italianWords) {
        this.germanWords = germanWords;
        this.spanishWords = spanishWords;
        this.frenchWords = frenchWords;
        this.italianWords = italianWords;
        this.countOfAllWords = setCountOfWordsInDictionary();
    }

    public int getCountOfAllWords() {
        return countOfAllWords;
    }

    public int setCountOfWordsInDictionary(){
        return germanWords.size()+spanishWords.size()+frenchWords.size()+italianWords.size();
    }
    public WordHomeViewModel setCountOfAllWords(int countOfAllWords) {
        this.countOfAllWords = countOfAllWords;
        return this;
    }
    public List<WordDTO> getGermanWords() {
        return germanWords;
    }

    public WordHomeViewModel setGermanWords(List<WordDTO> germanWords) {
        this.germanWords = germanWords;
        return this;
    }

    public List<WordDTO> getSpanishWords() {
        return spanishWords;
    }

    public WordHomeViewModel setSpanishWords(List<WordDTO> spanishWords) {
        this.spanishWords = spanishWords;
        return this;
    }

    public List<WordDTO> getFrenchWords() {
        return frenchWords;
    }

    public WordHomeViewModel setFrenchWords(List<WordDTO> frenchWords) {
        this.frenchWords = frenchWords;
        return this;
    }

    public List<WordDTO> getItalianWords() {
        return italianWords;
    }

    public WordHomeViewModel setItalianWords(List<WordDTO> italianWords) {
        this.italianWords = italianWords;
        return this;
    }
}
