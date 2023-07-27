package com.example.football.service.impl;

import com.example.football.models.dto.StatImportDto;
import com.example.football.models.dto.StatImportWrapperDto;
import com.example.football.models.entity.Stat;
import com.example.football.repository.StatRepository;
import com.example.football.service.StatService;
import com.example.football.util.ValidationUtils;
import com.example.football.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static com.example.football.models.Constants.*;

@Service
public class StatServiceImpl implements StatService {
    private static final String STATS_FILE_PATH = "skeleton/src/main/resources/files/xml/stats.xml";

    private final StatRepository statRepository;

    private final ValidationUtils validationUtils;

    private final ModelMapper modelMapper;

    private final XmlParser xmlParser;

    public StatServiceImpl(StatRepository statRepository, ValidationUtils validationUtils, ModelMapper modelMapper, XmlParser xmlParser) {
        this.statRepository = statRepository;
        this.validationUtils = validationUtils;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }


    @Override
    public boolean areImported() {
        return this.statRepository.count() > 0;
    }

    @Override
    public String readStatsFileContent() throws JAXBException, IOException {
        return Files.readString(Path.of(STATS_FILE_PATH));
    }

    @Override
    public String importStats() throws JAXBException, FileNotFoundException {
        StringBuilder stringBuilder = new StringBuilder();

        List<StatImportDto> stats = xmlParser.fromFile(Path.of(STATS_FILE_PATH).toFile(), StatImportWrapperDto.class)
                .getStats();

        for (StatImportDto stat : stats) {
            stringBuilder.append(System.lineSeparator());

            if (validationUtils.isValid(stat)){

                if(this.statRepository.findFirstByEnduranceAndAndPassingAndAndShooting(stat.getEndurance(),stat.getPassing(),stat.getShooting()).isEmpty()){

                    Stat statToSave = modelMapper.map(stat, Stat.class);
                    this.statRepository.save(statToSave);

                    stringBuilder.append(String.format("Successfully imported %s %.2f-%.2f-%.2f",
                            STAT,
                            stat.getShooting(),
                            stat.getPassing(),
                            stat.getEndurance()));

                        continue;
                }
            }
            stringBuilder.append(String.format(INVALID_FORMAT,STAT));
        }

        return stringBuilder.toString().trim();
    }
}
