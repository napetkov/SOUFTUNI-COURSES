package com.example.football.service.impl;

import com.example.football.models.dto.TownImportDto;
import com.example.football.models.entity.Town;
import com.example.football.repository.TownRepository;
import com.example.football.service.TownService;
import com.example.football.util.ValidationUtils;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;

import static com.example.football.models.Constants.*;


@Service
public class TownServiceImpl implements TownService {
    private static String TOWNS_FILE_PATH = "skeleton/src/main/resources/files/json/towns.json";
    private final TownRepository townRepository;
    private final ValidationUtils validationUtils;
    private final Gson gson;
    private final ModelMapper modelMapper;


    public TownServiceImpl(TownRepository townRepository, ValidationUtils validationUtils, Gson gson, ModelMapper modelMapper) {
        this.townRepository = townRepository;
        this.validationUtils = validationUtils;
        this.gson = gson;
        this.modelMapper = modelMapper;
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

        Arrays.stream(gson.fromJson(readTownsFileContent(), TownImportDto[].class))
                .filter(townImportDto -> {
                    boolean isValid = validationUtils.isValid(townImportDto);
                    Optional<Town> townByName = this.townRepository.findByName(townImportDto.getName());

                    if (townByName.isPresent()) {
                        isValid = false;
                    }

                    stringBuilder.append(isValid
                            ? String.format(SUCCESSFUL_FORMAT, TOWN, townImportDto.getName(), townImportDto.getPopulation())
                            : String.format(INVALID_FORMAT, TOWN))
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(townImportDto -> modelMapper.map(townImportDto,Town.class))
                .forEach(this.townRepository::save);

        return stringBuilder.toString().trim();
    }
}
