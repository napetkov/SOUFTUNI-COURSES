package com.example.football.service.impl;

import com.example.football.models.dto.PlayerImportWrapperDto;
import com.example.football.models.entity.Player;
import com.example.football.repository.PlayerRepository;
import com.example.football.repository.StatRepository;
import com.example.football.repository.TeamRepository;
import com.example.football.repository.TownRepository;
import com.example.football.service.PlayerService;
import com.example.football.util.ValidationUtils;
import com.example.football.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.example.football.models.Constants.*;

@Service
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;
    private final TownRepository townRepository;
    private final StatRepository statRepository;
    private final TeamRepository teamRepository;

    private static final String PLAYER_FILE_PATH = "skeleton/src/main/resources/files/xml/players.xml";

    private final ValidationUtils validationUtils;

    private final ModelMapper modelMapper;

    private final XmlParser xmlParser;

    public PlayerServiceImpl(PlayerRepository playerRepository, TownRepository townRepository, StatRepository statRepository, TeamRepository teamRepository, ValidationUtils validationUtils, ModelMapper modelMapper, XmlParser xmlParser) {
        this.playerRepository = playerRepository;
        this.townRepository = townRepository;
        this.statRepository = statRepository;
        this.teamRepository = teamRepository;
        this.validationUtils = validationUtils;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }


    @Override
    public boolean areImported() {
        return this.playerRepository.count() > 0;
    }

    @Override
    public String readPlayersFileContent() throws IOException {
        return Files.readString(Path.of(PLAYER_FILE_PATH));
    }

    @Override
    public String importPlayers() throws JAXBException, FileNotFoundException {
        StringBuilder stringBuilder = new StringBuilder();

        xmlParser.fromFile(Path.of(PLAYER_FILE_PATH).toFile(), PlayerImportWrapperDto.class).getPlayers()
                .stream().filter(playerImportDto -> {
                    boolean isValid = validationUtils.isValid(playerImportDto);

                    if (this.playerRepository.findByEmail(playerImportDto.getEmail()).isPresent()) isValid = false;


                    stringBuilder.append(isValid
                            ? String.format(SUCCESSFUL_FORMAT, PLAYER, playerImportDto.getFirstName() + " " + playerImportDto.getLastName(),playerImportDto.getPosition())
                            : String.format(INVALID_FORMAT, PLAYER));

                    stringBuilder.append(System.lineSeparator());

                    return isValid;
                })
                .map(player -> {
                    Player playerToSave = modelMapper.map(player, Player.class);

                    playerToSave.setTown(this.townRepository.findByName(player.getTown().getName()).get());
                    playerToSave.setTeam(this.teamRepository.findByName(player.getTeam().getName()).get());
                    playerToSave.setStat(this.statRepository.findById(player.getStat().getId()).get());

                    return playerToSave;
                })
                .forEach(playerRepository::save);


        return stringBuilder.toString().trim();
    }

    @Override
    public String exportBestPlayers() {
        return null;
    }
}
