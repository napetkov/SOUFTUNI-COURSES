package com.example.football.service.impl;

import com.example.football.models.dto.TeamImportDto;
import com.example.football.models.entity.Team;
import com.example.football.repository.TeamRepository;
import com.example.football.repository.TownRepository;
import com.example.football.service.TeamService;
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
public class TeamServiceImpl implements TeamService {

    private static String TEAMS_FILE_PATH = "skeleton/src/main/resources/files/json/teams.json";
    private final TeamRepository teamRepository;
    private final TownRepository townRepository;
    private final ValidationUtils validationUtils;
    private final Gson gson;
    private final ModelMapper modelMapper;

    public TeamServiceImpl(TeamRepository teamRepository, TownRepository townRepository, ValidationUtils validationUtils, Gson gson, ModelMapper modelMapper) {
        this.teamRepository = teamRepository;
        this.townRepository = townRepository;
        this.validationUtils = validationUtils;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.teamRepository.count() > 0;
    }

    @Override
    public String readTeamsFileContent() throws IOException {
        return Files.readString(Path.of(TEAMS_FILE_PATH));
    }

    @Override
    public String importTeams() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        Arrays.stream(gson.fromJson(readTeamsFileContent(), TeamImportDto[].class))
                .filter(teamImportDto -> {
                    boolean isValid = validationUtils.isValid(teamImportDto);

                    Optional<Team> teamByName = this.teamRepository.findByName(teamImportDto.getName());

                    if (teamByName.isPresent()) isValid = false;

                    stringBuilder.append(isValid
                                    ? String.format(SUCCESSFUL_FORMAT, TEAM, teamImportDto.getName(), teamImportDto.getFanBase())
                                    : String.format(INVALID_FORMAT, TEAM))
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(teamImportDto -> {
                    Team teamToSave = modelMapper.map(teamImportDto, Team.class);
                    teamToSave.setTown(this.townRepository.findByName(teamImportDto.getTownName()).get()); //•	The provided town names will always be valid.
                    return teamToSave;
                })
                .forEach(this.teamRepository::save);

        return stringBuilder.toString().trim();
    }
}
