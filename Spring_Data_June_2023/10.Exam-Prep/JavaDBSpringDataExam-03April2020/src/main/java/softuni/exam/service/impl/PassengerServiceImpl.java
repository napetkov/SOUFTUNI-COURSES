package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.PassengerImportDto;
import softuni.exam.models.entitnies.Passenger;
import softuni.exam.models.entitnies.Town;
import softuni.exam.repository.PassengerRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.PassengerService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static softuni.exam.models.Constants.*;

@Service
public class PassengerServiceImpl implements PassengerService {
    private final String PASSENGER_FILE_PATH = "src/main/resources/files/json/passengers.json";
    private final PassengerRepository passengerRepository;
    private final TownRepository townRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtils validationUtils;

    public PassengerServiceImpl(PassengerRepository passengerRepository, TownRepository townRepository, Gson gson, ModelMapper modelMapper, ValidationUtils validationUtils) {
        this.passengerRepository = passengerRepository;
        this.townRepository = townRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return this.passengerRepository.count() > 0;
    }

    @Override
    public String readPassengersFileContent() throws IOException {
        return Files.readString(Path.of(PASSENGER_FILE_PATH));
    }

    @Override
    public String importPassengers() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        Arrays.stream(gson.fromJson(readPassengersFileContent(), PassengerImportDto[].class))
                .filter(passengerImportDto -> {
                    boolean isValid = validationUtils.isValid(passengerImportDto);

                    stringBuilder.append(isValid
                            ? String.format(SUCCESSFUL_FORMAT, PASSENGER, passengerImportDto.getLastName() + " -", passengerImportDto.getEmail())
                            : String.format(INVALID_FORMAT, PASSENGER));

                    stringBuilder.append(System.lineSeparator());

                    return isValid;
                })
                .map(passenger -> {
                    Passenger passengerToSave = modelMapper.map(passenger, Passenger.class);

                    Town town = this.townRepository.findFirstByName(passenger.getTown()).orElse(null);

                    passengerToSave.setTown(town);

                    return passengerToSave;
                })
                .forEach(this.passengerRepository::save);

        return stringBuilder.toString().trim();
    }

    @Override
    public String getPassengersOrderByTicketsCountDescendingThenByEmail() {
        return null;
    }
}
