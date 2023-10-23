package com.dictionaryapp.init;

import com.dictionaryapp.model.entity.Language;
import com.dictionaryapp.model.enums.LanguageName;
import com.dictionaryapp.repo.LanguageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Component
public class LanguageInit implements CommandLineRunner {
private final LanguageRepository languageRepository;

    public LanguageInit(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        long count = languageRepository.count();
        List<Language> languages = new ArrayList<>();

        if (count==0){
            Arrays.stream(LanguageName.values())
                    .forEach(languageName -> {
                        Language language = new Language();
                        language.setName(languageName);

                        languages.add(language);
                    });
        }

        languageRepository.saveAll(languages);
    }
}
