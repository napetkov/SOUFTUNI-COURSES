package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CarImportDto;
import softuni.exam.models.dto.CarsWrapperDto;
import softuni.exam.models.entity.Car;
import softuni.exam.repository.CarsRepository;
import softuni.exam.service.CarsService;
import softuni.exam.util.ValidationUtils;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static softuni.exam.models.Constant.*;

// TODO: Implement all methods
@Service
public class CarsServiceImpl implements CarsService {

    private final CarsRepository carsRepository;
    private final XmlParser xmlParser;
    private final ValidationUtils validationUtils;
    private final ModelMapper mapper;

    private static String CARS_FILE_PATH = "src/main/resources/files/xml/cars.xml";

    @Autowired
    public CarsServiceImpl(CarsRepository carsRepository, XmlParser xmlParser, ValidationUtils validationUtils, ModelMapper mapper) {
        this.carsRepository = carsRepository;
        this.xmlParser = xmlParser;
        this.validationUtils = validationUtils;
        this.mapper = mapper;
    }

    @Override
    public boolean areImported() {
        return this.carsRepository.count() > 0;
    }

    @Override
    public String readCarsFromFile() throws IOException {
        return Files.readString(Path.of(CARS_FILE_PATH));
    }

    @Override
    public String importCars() throws IOException, JAXBException {
        StringBuilder stringBuilder = new StringBuilder();

        String file = this.readCarsFromFile();

        List<CarImportDto> cars = this.xmlParser.fromFile(Path.of(CARS_FILE_PATH).toFile(), CarsWrapperDto.class)
                .getCars();

        for (CarImportDto car : cars) {
            stringBuilder.append(System.lineSeparator());

            if (this.carsRepository.findFirstByPlateNumber(car.getPlateNumber()).isPresent() ||
                    !this.validationUtils.isValid(car)) {

                stringBuilder.append(String.format(INVALID_FORMAT,CAR));
                continue;
            }

            this.carsRepository.save(this.mapper.map(car, Car.class));

            stringBuilder.append(String.format(SUCCESSFUL_FORMAT,
                    CAR,
                    car.getCarMake() + " -",
                    car.getCarModel()));
        }


        return stringBuilder.toString().trim();
    }
}
