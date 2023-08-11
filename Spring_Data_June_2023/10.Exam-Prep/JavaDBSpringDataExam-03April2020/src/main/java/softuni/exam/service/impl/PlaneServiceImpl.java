package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.PlaneWrapperImportDto;
import softuni.exam.models.entitnies.Plane;
import softuni.exam.repository.PlaneRepository;
import softuni.exam.service.PlaneService;
import softuni.exam.util.ValidationUtils;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static softuni.exam.models.Constants.*;

@Service
public class PlaneServiceImpl implements PlaneService {
    private final String PLANE_FILE_PATH = "src/main/resources/files/xml/planes.xml";
    private final PlaneRepository planeRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtils validationUtils;


    public PlaneServiceImpl(PlaneRepository planeRepository, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtils validationUtils) {
        this.planeRepository = planeRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return this.planeRepository.count() > 0;
    }

    @Override
    public String readPlanesFileContent() throws IOException {
        return Files.readString(Path.of(PLANE_FILE_PATH));
    }

    @Override
    public String importPlanes() throws JAXBException, FileNotFoundException {
        StringBuilder stringBuilder = new StringBuilder();

        xmlParser.fromFile(Path.of(PLANE_FILE_PATH).toFile(), PlaneWrapperImportDto.class)
                .getPlanes()
                .stream().filter(planeImportDto -> {
                    boolean isValid = validationUtils.isValid(planeImportDto);

                    stringBuilder.append(isValid
                            ? String.format(SUCCESSFUL_FORMAT, PLANE, planeImportDto.getRegisterNumber(), "")
                            : String.format(INVALID_FORMAT, PLANE));

                    stringBuilder.append(System.lineSeparator());

                    return isValid;
                })
                .map(planeToSave -> modelMapper.map(planeToSave, Plane.class))
                .forEach(this.planeRepository::save);

        return stringBuilder.toString().trim();
    }
}
