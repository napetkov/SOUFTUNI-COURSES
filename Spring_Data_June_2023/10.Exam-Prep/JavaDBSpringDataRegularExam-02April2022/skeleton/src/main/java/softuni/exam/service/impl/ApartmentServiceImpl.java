package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ApartmentImportDto;
import softuni.exam.models.dto.ApartmentImportWrapperDto;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.ApartmentType;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.ApartmentService;
import softuni.exam.util.ValidationUtils;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

import static softuni.exam.models.Constant.*;

@Service
public class ApartmentServiceImpl implements ApartmentService {
    private static final String APARTMENTS_FILE_PATH = "src/main/resources/files/xml/apartments.xml";

    private final TownRepository townRepository;
    private final ModelMapper mapper;
    private final ValidationUtils validationUtils;
    private final XmlParser xmlParser;



    private final ApartmentRepository apartmentRepository;

    public ApartmentServiceImpl(TownRepository townRepository, ModelMapper mapper, ValidationUtils validationUtils, XmlParser xmlParser, ApartmentRepository apartmentRepository) {
        this.townRepository = townRepository;
        this.mapper = mapper;
        this.validationUtils = validationUtils;
        this.xmlParser = xmlParser;
        this.apartmentRepository = apartmentRepository;
    }

    @Override
    public boolean areImported() {
        return this.apartmentRepository.count() > 0;
    }

    @Override
    public String readApartmentsFromFile() throws IOException {
        return Files.readString(Path.of(APARTMENTS_FILE_PATH));
    }

    @Override
    public String importApartments() throws IOException, JAXBException {
        StringBuilder stringBuilder = new StringBuilder();

        List<ApartmentImportDto> apartments = xmlParser.fromFile(Path.of(APARTMENTS_FILE_PATH).toFile(), ApartmentImportWrapperDto.class).getApartments().stream().toList();


        for (ApartmentImportDto apartment : apartments) {
            stringBuilder.append(System.lineSeparator());

            if (this.apartmentRepository.findFirstByTownTownNameAndArea(apartment.getTown(),apartment.getArea()).isPresent()
                    ||!validationUtils.isValid(apartment)) {
                stringBuilder.append(String.format(INVALID_FORMAT,APARTMENT));

                continue;
            }

            Apartment apartmentToSave = mapper.map(apartment, Apartment.class);
//            apartmentToSave.setApartmentType(ApartmentType.valueOf(apartment.getApartmentType()));

            Optional<Town> town = this.townRepository.findFirstByTownName(apartment.getTown());
            apartmentToSave.setTown(town.get());

            this.apartmentRepository.save(apartmentToSave);

            stringBuilder.append(String.format(SUCCESSFUL_FORMAT,APARTMENT,apartment.getApartmentType()+" -",apartment.getArea()));

        }


        return stringBuilder.toString().trim();
    }
}
