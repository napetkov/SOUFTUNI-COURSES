package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.AstronomersImportWrapperDto;
import softuni.exam.models.entity.Astronomer;
import softuni.exam.models.entity.Star;
import softuni.exam.repository.AstronomerRepository;
import softuni.exam.repository.StarRepository;
import softuni.exam.service.AstronomerService;
import softuni.exam.util.ValidationUtils;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;

import static softuni.exam.models.Constants.*;

@Service
public class AstronomerServiceImpl implements AstronomerService {
    private final String ASTRONOMERS_FILE_PATH = "src/main/resources/files/xml/astronomers.xml";
    private final StarRepository starRepository;
    private final AstronomerRepository astronomerRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidationUtils validationUtils;


    public AstronomerServiceImpl(StarRepository starRepository,
                                 AstronomerRepository astronomerRepository,
                                 ModelMapper modelMapper,
                                 XmlParser xmlParser,
                                 ValidationUtils validationUtils) {
        this.starRepository = starRepository;
        this.astronomerRepository = astronomerRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtils = validationUtils;
    }


    @Override
    public boolean areImported() {
        return this.astronomerRepository.count() > 0;
    }

    @Override
    public String readAstronomersFromFile() throws IOException {
        return Files.readString(Path.of(ASTRONOMERS_FILE_PATH));
    }

    @Override
    public String importAstronomers() throws IOException, JAXBException {
        StringBuilder stringBuilder = new StringBuilder();

        xmlParser.fromFile(Path.of(ASTRONOMERS_FILE_PATH).toFile(), AstronomersImportWrapperDto.class)
                .getAstronomers()
                .stream().filter(astronomersImportDto -> {
                    boolean isValid = validationUtils.isValid(astronomersImportDto);

                    if (this.astronomerRepository.findFirstByFirstNameAndLastName
                            (astronomersImportDto.getFirstName(),astronomersImportDto.getLastName()).isPresent()
                            || this.starRepository.findById(astronomersImportDto.getStarId()).isEmpty()) isValid = false;

                    stringBuilder.append(isValid
                    ?String.format(SUCCESSFUL_FORMAT,
                            ASTRONOMER,
                            astronomersImportDto.getFirstName() + " " + astronomersImportDto.getLastName(),
                            String.format(Locale.US,"%.2f",astronomersImportDto.getAverageObservationHours()))
                    :String.format(INVALID_FORMAT,ASTRONOMER));

                    stringBuilder.append(System.lineSeparator());

                    return isValid;
                })
                .map(astronomersImportDto -> {
                    Star star = this.starRepository.findById(astronomersImportDto.getStarId()).get();

                    Astronomer astronomerToSave = modelMapper.map(astronomersImportDto, Astronomer.class);
                    astronomerToSave.setStar(star);
                    return astronomerToSave;
                })
                .forEach(this.astronomerRepository::save);

        return stringBuilder.toString().trim();
    }
}
