package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.TownImportDto;
import softuni.exam.models.entitnies.Town;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static softuni.exam.models.Constants.*;

@Service
public class TownServiceImpl implements TownService {
    private final String TOWN_FILE_PATH = "src/main/resources/files/json/towns.json";
    private final TownRepository townRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtils validationUtils;

    public TownServiceImpl(TownRepository townRepository, Gson gson, ModelMapper modelMapper, ValidationUtils validationUtils) {
        this.townRepository = townRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return this.townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(Path.of(TOWN_FILE_PATH));
    }

    @Override
    public String importTowns() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        Arrays.stream(gson.fromJson(readTownsFileContent(), TownImportDto[].class))
                .filter(townImportDto -> {
                    boolean isValid = validationUtils.isValid(townImportDto);

                    stringBuilder.append(isValid
                            ? String.format(SUCCESSFUL_FORMAT, TOWN, townImportDto.getName() + " -", townImportDto.getPopulation())
                            : String.format(INVALID_FORMAT, TOWN));

                    stringBuilder.append(System.lineSeparator());

                    return isValid;
                })
                .map(townToSave -> modelMapper.map(townToSave, Town.class))
                .forEach(this.townRepository::save);

        return stringBuilder.toString().trim();
    }
}
