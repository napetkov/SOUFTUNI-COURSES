package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.util.EnumUtils;
import softuni.exam.models.dto.ExportForecastDto;
import softuni.exam.models.dto.ForecastDto;
import softuni.exam.models.dto.ForecastsImportWrapperDto;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.DayOfWeek;
import softuni.exam.models.entity.Forecast;
import softuni.exam.repository.CityRepository;
import softuni.exam.repository.ForecastRepository;
import softuni.exam.service.ForecastService;
import softuni.exam.util.ValidationUtils;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static softuni.exam.models.Constant.*;

@Service
public class ForecastServiceImpl implements ForecastService {

    private final ForecastRepository forecastRepository;
    private final CityRepository cityRepository;
    private final ValidationUtils validationUtils;
    private final ModelMapper mapper;
    private final XmlParser xmlParser;

    private static final String FORECAST_FILE_PATH = "src/main/resources/files/xml/forecasts.xml";

    public ForecastServiceImpl(ForecastRepository forecastRepository, CityRepository cityRepository, ValidationUtils validationUtils, ModelMapper mapper, XmlParser xmlParser) {
        this.forecastRepository = forecastRepository;
        this.cityRepository = cityRepository;
        this.validationUtils = validationUtils;
        this.mapper = mapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return this.forecastRepository.count() > 0;
    }

    @Override
    public String readForecastsFromFile() throws IOException {
        return Files.readString(Path.of(FORECAST_FILE_PATH));
    }

    @Override
    public String importForecasts() throws IOException, JAXBException {
        StringBuilder stringBuilder = new StringBuilder();

        List<ForecastDto> forecasts = xmlParser
                .fromFile(Path.of(FORECAST_FILE_PATH).toFile(), ForecastsImportWrapperDto.class)
                .getForecasts();

        for (ForecastDto forecast : forecasts) {
            stringBuilder.append(System.lineSeparator());

            Optional<City> city = cityRepository.findById(forecast.getCity());

            boolean dayOfWeekIsPresent = Arrays.stream(DayOfWeek.values()).map(Enum::toString).toList().contains(forecast.getDayOfWeek());

            if (!dayOfWeekIsPresent
                    ||(this.forecastRepository.findFirstByCityIdAndDayOfWeek(forecast.getCity(), DayOfWeek.valueOf(forecast.getDayOfWeek())).isPresent()
                    || !validationUtils.isValid(forecast)
                    || city.isEmpty())) {
                stringBuilder.append(String.format(INVALID_FORMAT, FORECAST));
                continue;
            }

            Forecast forecastToSave = mapper.map(forecast, Forecast.class);
            forecastToSave.setCity(city.get());

            LocalTime sunrise = LocalTime.parse(forecast.getSunrise());
            forecastToSave.setSunrise(sunrise);

            LocalTime sunset = LocalTime.parse(forecast.getSunset());
            forecastToSave.setSunset(sunset);

            this.forecastRepository.save(forecastToSave);

            stringBuilder.append(String.format(SUCCESSFUL_FORMAT,FORECAST,forecast.getDayOfWeek(),forecast.getMaxTemperature()));
        }

        return stringBuilder.toString().trim();
    }

    @Override
    public String exportForecasts() {
        return this.forecastRepository.findAllByDayOfWeekAndCityPopulationLessThan(DayOfWeek.SUNDAY,150000)
                .stream().map(forecast -> mapper.map(forecast, ExportForecastDto.class))
                .map(ExportForecastDto::toString)
                .collect(Collectors.joining("\n"));
    }
}
