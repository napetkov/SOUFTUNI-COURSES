package exam.service.impl;

import exam.model.dto.TownImportWrapperDto;
import exam.model.entity.Town;
import exam.repository.TownRepository;
import exam.service.TownService;
import exam.util.ValidationUtils;
import exam.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

import static exam.model.Constants.*;

@Service
public class TownServiceImpl implements TownService {
    private static final String TOWNS_FILE_PATH = "src/main/resources/files/xml/towns.xml";
    private final TownRepository townRepository;

    private final XmlParser xmlParser;

    private final ValidationUtils validationUtils;

    private final ModelMapper modelMapper;

    public TownServiceImpl(TownRepository townRepository, XmlParser xmlParser, ValidationUtils validationUtils, ModelMapper modelMapper) {
        this.townRepository = townRepository;
        this.xmlParser = xmlParser;
        this.validationUtils = validationUtils;
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
    public String importTowns() throws JAXBException, FileNotFoundException {
        StringBuilder stringBuilder = new StringBuilder();

        xmlParser.fromFile(Path.of(TOWNS_FILE_PATH).toFile(), TownImportWrapperDto.class)
                .getTowns()
                .stream().filter(townImportDto -> {
                    boolean isValid = validationUtils.isValid(townImportDto);

                    Optional<Town> town = this.townRepository.findFirstByName(townImportDto.getName());

                    if(town.isPresent()) isValid = false;

                    stringBuilder.append(isValid
                            ?String.format(SUCCESSFUL_FORMAT,TOWN,townImportDto.getName(),"")
                            :String.format(INVALID_FORMAT,TOWN))
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(town -> modelMapper.map(town,Town.class))
                .forEach(this.townRepository::save);

        return stringBuilder.toString().trim();
    }
}
