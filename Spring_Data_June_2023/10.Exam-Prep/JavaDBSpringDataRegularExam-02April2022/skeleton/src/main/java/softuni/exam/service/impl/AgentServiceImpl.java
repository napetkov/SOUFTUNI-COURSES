package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.AgentImportDto;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.AgentService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static softuni.exam.models.Constant.*;

@Service
public class AgentServiceImpl implements AgentService {
    private static final String AGENTS_FILE_PATH = "src/main/resources/files/json/agents.json";

    private final AgentRepository agentRepository;
    private final TownRepository townRepository;
    private final Gson gson;
    private final ModelMapper mapper;
    private final ValidationUtils validationUtils;

    public AgentServiceImpl(AgentRepository agentRepository, TownRepository townRepository, Gson gson, ModelMapper mapper, ValidationUtils validationUtils) {
        this.agentRepository = agentRepository;
        this.townRepository = townRepository;
        this.gson = gson;
        this.mapper = mapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return this.agentRepository.count() > 0;
    }

    @Override
    public String readAgentsFromFile() throws IOException {
        return Files.readString(Path.of(AGENTS_FILE_PATH));
    }

    @Override
    public String importAgents() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        List<AgentImportDto> agents = Arrays.stream(gson.fromJson(readAgentsFromFile(), AgentImportDto[].class)).toList();

        for (AgentImportDto agent : agents) {
            stringBuilder.append(System.lineSeparator());

            if (this.agentRepository.findFirstByFirstName(agent.getFirstName()).isPresent()
                    || !validationUtils.isValid(agent)) {
                stringBuilder.append(String.format(INVALID_FORMAT, AGENT));

                continue;
            }

            Optional<Town> town = this.townRepository.findFirstByTownName(agent.getTown());

            Agent agentToSave = mapper.map(agent, Agent.class);
            agentToSave.setTown(town.get());

            this.agentRepository.save(agentToSave);

            stringBuilder.append(String.format(SUCCESSFUL_FORMAT, AGENT, "- " + agent.getFirstName(), agent.getLastName()));

        }


        return stringBuilder.toString().trim();
    }
}
