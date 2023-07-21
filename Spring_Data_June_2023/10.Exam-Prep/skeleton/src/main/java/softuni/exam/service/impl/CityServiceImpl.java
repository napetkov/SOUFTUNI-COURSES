package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CityImportDto;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CityRepository;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CityService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static softuni.exam.models.Constant.*;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;
    private final ValidationUtils validationUtils;
    private final ModelMapper mapper;
    private final Gson gson;

    private static final String CITIES_FILE_PATH = "src/main/resources/files/json/cities.json";

    public CityServiceImpl(CityRepository cityRepository, CountryRepository countryRepository, ValidationUtils validationUtils, ModelMapper mapper, Gson gson) {
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
        this.validationUtils = validationUtils;
        this.mapper = mapper;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return this.cityRepository.count() > 0;
    }

    @Override
    public String readCitiesFileContent() throws IOException {
        return Files.readString(Path.of(CITIES_FILE_PATH));
    }

    @Override
    public String importCities() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        List<CityImportDto> cities = Arrays.stream(gson.fromJson(readCitiesFileContent(), CityImportDto[].class)).toList();


        for (CityImportDto city : cities) {
            stringBuilder.append(System.lineSeparator());
            Optional<Country> country = this.countryRepository.findById(city.getCountry());
            if (cityRepository.findByCityName(city.getCityName()).isPresent()
                    || !validationUtils.isValid(city)
                    || country.isEmpty()) {
                stringBuilder.append(String.format(INVALID_FORMAT, CITY));
                continue;
            }

            City cityToSave = mapper.map(city, City.class);
            cityToSave.setCountry(country.get());
            this.cityRepository.save(cityToSave);

            stringBuilder.append(String.format(SUCCESSFUL_FORMAT, CITY, city.getCityName(), city.getPopulation()));

        }


        return stringBuilder.toString().trim();
    }
}
