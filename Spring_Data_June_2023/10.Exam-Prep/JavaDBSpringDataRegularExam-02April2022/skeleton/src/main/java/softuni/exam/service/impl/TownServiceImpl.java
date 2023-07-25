package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.TownImportDto;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static softuni.exam.models.Constant.*;

@Service
public class TownServiceImpl implements TownService {
    private static final String TOWNS_FILE_PATH = "src/main/resources/files/json/towns.json";

    private final TownRepository townRepository;
    private final Gson gson;
    private final ModelMapper mapper;
    private final ValidationUtils validationUtils;

    public TownServiceImpl(TownRepository townRepository, Gson gson, ModelMapper mapper, ValidationUtils validationUtils) {
        this.townRepository = townRepository;
        this.gson = gson;
        this.mapper = mapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return this.townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(Path.of(TOWNS_FILE_PATH));
    }

    @Override
    public String importTowns() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        List<TownImportDto> towns = Arrays.stream(gson.fromJson(readTownsFileContent(), TownImportDto[].class)).toList();

        for (TownImportDto town : towns) {
            stringBuilder.append(System.lineSeparator());

            if (this.townRepository.findFirstByTownName(town.getTownName()).isPresent()
                    || !validationUtils.isValid(town)) {
                    stringBuilder.append(String.format(INVALID_FORMAT,TOWN));

                    continue;
            }

            this.townRepository.save(mapper.map(town, Town.class));

            stringBuilder.append(String.format(SUCCESSFUL_FORMAT,TOWN,town.getTownName() + " -",town.getPopulation()));
        }


        return stringBuilder.toString().trim();
    }
}
