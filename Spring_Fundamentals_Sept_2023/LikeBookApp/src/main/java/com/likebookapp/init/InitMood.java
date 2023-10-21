package com.likebookapp.init;

import com.likebookapp.model.entity.Mood;
import com.likebookapp.model.enums.MoodName;
import com.likebookapp.repository.MoodRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class InitMood implements CommandLineRunner {
    private final MoodRepository moodRepository;

    public InitMood(MoodRepository moodRepository) {
        this.moodRepository = moodRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        long cont = moodRepository.count();
        List<Mood> moods = new ArrayList<>();

        if (cont == 0) {
            Arrays.stream(MoodName.values())
                    .forEach(moodName -> {
                Mood mood = new Mood();
                mood.setName(moodName)
                        .setDescription("optional...");

                moods.add(mood);
            });
        }
        moodRepository.saveAll(moods);

    }
}
