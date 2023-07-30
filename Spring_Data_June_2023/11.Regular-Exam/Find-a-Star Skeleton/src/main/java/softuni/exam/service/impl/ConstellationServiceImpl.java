package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ConstellationImportDto;
import softuni.exam.models.entity.Constellation;
import softuni.exam.repository.ConstellationRepository;
import softuni.exam.service.ConstellationService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static softuni.exam.models.Constants.*;

@Service
public class ConstellationServiceImpl implements ConstellationService {
    private final String CONSTELLATION_FILE_PATH = "src/main/resources/files/json/constellations.json";
    private final ConstellationRepository constellationRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtils validationUtils;

    public ConstellationServiceImpl(ConstellationRepository constellationRepository, Gson gson, ModelMapper modelMapper, ValidationUtils validationUtils) {
        this.constellationRepository = constellationRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return this.constellationRepository.count() > 0;
    }

    @Override
    public String readConstellationsFromFile() throws IOException {
        return Files.readString(Path.of(CONSTELLATION_FILE_PATH));
    }

    @Override
    public String importConstellations() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        Arrays.stream(gson.fromJson(readConstellationsFromFile(), ConstellationImportDto[].class))
                .filter(constellationImportDto -> {
                    boolean isValid = validationUtils.isValid(constellationImportDto);

                    if (this.constellationRepository.findFirstByName(constellationImportDto.getName()).isPresent())
                        isValid = false;

                    stringBuilder.append(isValid
                            ? String.format(SUCCESSFUL_FORMAT, CONSTELLATION, constellationImportDto.getName(), constellationImportDto.getDescription())
                            : String.format(INVALID_FORMAT, CONSTELLATION));

                    stringBuilder.append(System.lineSeparator());

                    return isValid;
                })
                .map(constellationImportDto -> modelMapper.map(constellationImportDto, Constellation.class))
                .forEach(this.constellationRepository::save);


        return stringBuilder.toString().trim();
    }
}
