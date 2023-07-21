package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CountryImportDto;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CountryService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static softuni.exam.models.Constant.*;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    private final ValidationUtils validationUtils;
    private final ModelMapper mapper;
    private final Gson gson;

    private static final String COUNTRY_FILE_PATH = "src/main/resources/files/json/countries.json";

    public CountryServiceImpl(CountryRepository countryRepository, ValidationUtils validationUtils, ModelMapper mapper, Gson gson) {
        this.countryRepository = countryRepository;
        this.validationUtils = validationUtils;
        this.mapper = mapper;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return this.countryRepository.count() > 0;
    }

    @Override
    public String readCountriesFromFile() throws IOException {
        return Files.readString(Path.of(COUNTRY_FILE_PATH));
    }

    @Override
    public String importCountries() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        List<CountryImportDto> countries = Arrays.stream(gson.fromJson(readCountriesFromFile(), CountryImportDto[].class)).toList();

        for (CountryImportDto country : countries) {
            stringBuilder.append(System.lineSeparator());

            if (this.countryRepository.findFirstByCountryName(country.getCountryName()).isPresent()
                    || !validationUtils.isValid(country)) {

                stringBuilder.append(String.format(INVALID_FORMAT, COUNTRY));

                continue;
            }

            this.countryRepository.save(mapper.map(country, Country.class));

            stringBuilder.append(String.format(SUCCESSFUL_FORMAT,
                    COUNTRY,
                    country.getCountryName(),
                    country.getCurrency()));
        }


        return stringBuilder.toString().trim();
    }
}
