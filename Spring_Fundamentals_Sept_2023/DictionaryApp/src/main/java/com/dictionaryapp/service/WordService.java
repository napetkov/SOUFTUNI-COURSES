package com.dictionaryapp.service;

import com.dictionaryapp.model.dto.word.WordAddBindingModel;
import com.dictionaryapp.model.dto.word.WordHomeViewModel;

public interface WordService {

    void add(WordAddBindingModel wordAddBindingModel,String username);

    WordHomeViewModel getHomeViewData();

    void remove(Long id);

    void removeAll();
}
