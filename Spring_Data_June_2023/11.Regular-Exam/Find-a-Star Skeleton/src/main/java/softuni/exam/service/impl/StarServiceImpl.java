package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ExportStarDto;
import softuni.exam.models.dto.StarImportDto;
import softuni.exam.models.entity.Constellation;
import softuni.exam.models.entity.Star;
import softuni.exam.models.entity.StarType;
import softuni.exam.repository.AstronomerRepository;
import softuni.exam.repository.ConstellationRepository;
import softuni.exam.repository.StarRepository;
import softuni.exam.service.StarService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static softuni.exam.models.Constants.*;

@Service
public class StarServiceImpl implements StarService {
    private final String STAR_FILE_PATH = "src/main/resources/files/json/stars.json";
    private final ConstellationRepository constellationRepository;
    private final AstronomerRepository astronomerRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtils validationUtils;

    private final StarRepository starRepository;

    public StarServiceImpl(ConstellationRepository constellationRepository, AstronomerRepository astronomerRepository, Gson gson, ModelMapper modelMapper, ValidationUtils validationUtils, StarRepository starRepository) {
        this.constellationRepository = constellationRepository;
        this.astronomerRepository = astronomerRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
        this.starRepository = starRepository;
    }

    @Override
    public boolean areImported() {
        return this.starRepository.count() > 0;
    }

    @Override
    public String readStarsFileContent() throws IOException {
        return Files.readString(Path.of(STAR_FILE_PATH));
    }

    @Override
    public String importStars() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        Arrays.stream(gson.fromJson(readStarsFileContent(), StarImportDto[].class))
                .filter(starImportDto -> {
                    boolean isValid = validationUtils.isValid(starImportDto);

                    if (this.starRepository.findFirstByName(starImportDto.getName()).isPresent()) isValid = false;

                    stringBuilder.append(isValid
                            ? String.format(SUCCESSFUL_FORMAT, STAR, starImportDto.getName(), String.format(Locale.US, "%.2f light years", starImportDto.getLightYears()))
                            : String.format(INVALID_FORMAT, STAR));

                    stringBuilder.append(System.lineSeparator());

                    return isValid;
                })
                .map(starImportDto -> {
                    Constellation constellation = this.constellationRepository.findById(starImportDto.getConstellation()).get();

                    Star starToSave = modelMapper.map(starImportDto, Star.class);
                    starToSave.setConstellation(constellation);

                    return starToSave;
                })
                .forEach(this.starRepository::save);

        return stringBuilder.toString().trim();
    }

    @Override
    public String exportStars() {
//        return this.starRepository.findAllByStarTypeAndNotObserving(StarType.RED_GIANT)
//                .stream().map(star -> modelMapper.map(star, ExportStarDto.class)).collect(Collectors.toList())
//                .stream().map(ExportStarDto::toString)
//                .collect(Collectors.joining());

//        return this.starRepository.findAllByStarTypeOrderByLightYears(StarType.RED_GIANT)
//                .stream().filter(star -> this.astronomerRepository.findFirstByStarId(star.getId()).isEmpty())
//                .map(star -> modelMapper.map(star, ExportStarDto.class)).collect(Collectors.toList())
//                .stream().map(ExportStarDto::toString)
//                .collect(Collectors.joining());

        return this.starRepository.findAllByStarTypeOrderByLightYearsAndNotObserving(StarType.RED_GIANT)
                .stream().map(star -> modelMapper.map(star, ExportStarDto.class)).collect(Collectors.toList())
                .stream().map(ExportStarDto::toString)
                .collect(Collectors.joining());

    }
}
