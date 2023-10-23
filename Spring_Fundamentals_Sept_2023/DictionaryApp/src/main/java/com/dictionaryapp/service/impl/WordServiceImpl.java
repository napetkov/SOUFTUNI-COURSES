package com.dictionaryapp.service.impl;

import com.dictionaryapp.model.dto.word.WordAddBindingModel;
import com.dictionaryapp.model.dto.word.WordDTO;
import com.dictionaryapp.model.dto.word.WordHomeViewModel;
import com.dictionaryapp.model.entity.Language;
import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.model.entity.Word;
import com.dictionaryapp.model.enums.LanguageName;
import com.dictionaryapp.repo.LanguageRepository;
import com.dictionaryapp.repo.UserRepository;
import com.dictionaryapp.repo.WordRepository;
import com.dictionaryapp.service.WordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordServiceImpl implements WordService {
    private final WordRepository wordRepository;
    private final LanguageRepository languageRepository;
    private final UserRepository userRepository;


    public WordServiceImpl(WordRepository wordRepository, LanguageRepository languageRepository, UserRepository userRepository) {
        this.wordRepository = wordRepository;
        this.languageRepository = languageRepository;
        this.userRepository = userRepository;
    }


    @Override
    public void add(WordAddBindingModel wordAddBindingModel, String username) {
        Language language = languageRepository.findByName(wordAddBindingModel.getLanguage());
        User user = userRepository.findByUsername(username);

        if (language != null){
            Word word = new Word();
            word.setTerm(wordAddBindingModel.getTerm())
                    .setExample(wordAddBindingModel.getExample())
                    .setTranslation(wordAddBindingModel.getTranslation())
                    .setInputDate(wordAddBindingModel.getInputDate())
                    .setLanguage(language)
                    .setAddedBy(user);

        wordRepository.save(word);
        }
    }

    @Override
    public WordHomeViewModel getHomeViewData() {
        List<WordDTO> germanWords = wordRepository.findByLanguageName(LanguageName.GERMAN)
                .stream().map(WordDTO::createFromWordEntity)
                .toList();
        List<WordDTO> spanishWords = wordRepository.findByLanguageName(LanguageName.SPANISH)
                .stream().map(WordDTO::createFromWordEntity)
                .toList();
        List<WordDTO> frenchWords = wordRepository.findByLanguageName(LanguageName.FRENCH)
                .stream().map(WordDTO::createFromWordEntity)
                .toList();
        List<WordDTO> italianWords = wordRepository.findByLanguageName(LanguageName.ITALIAN)
                .stream().map(WordDTO::createFromWordEntity)
                .toList();

        return new WordHomeViewModel(germanWords,spanishWords,frenchWords,italianWords);
    }

    @Override
    public void remove(Long id) {
        wordRepository.deleteById(id);
    }

    @Override
    public void removeAll() {
        wordRepository.deleteAll();
    }
}
