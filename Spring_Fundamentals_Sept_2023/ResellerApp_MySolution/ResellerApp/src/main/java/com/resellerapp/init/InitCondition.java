package com.resellerapp.init;

import com.resellerapp.model.entity.Condition;
import com.resellerapp.model.enums.ConditionName;
import com.resellerapp.repository.ConditionsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class InitCondition implements CommandLineRunner {
    private final ConditionsRepository conditionsRepository;

    public InitCondition(ConditionsRepository conditionsRepository) {
        this.conditionsRepository = conditionsRepository;
    }

    @Override
    public void run(String... args) throws Exception {
            long count = conditionsRepository.count();
        List<Condition> conditions = new ArrayList<>();

            if(count==0){
                Arrays.stream(ConditionName.values())
                        .forEach(conditionName->{
                            Condition condition = new Condition();
                            condition.setName(conditionName);

                            conditions.add(condition);
                        });

                conditionsRepository.saveAll(conditions);

            }


    }
}
