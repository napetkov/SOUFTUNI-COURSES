package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dto.PicturesImportDto;
import softuni.exam.instagraphlite.models.entity.Picture;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static softuni.exam.instagraphlite.models.Constants.*;

@Service
public class PictureServiceImpl implements PictureService {
    private final String PICTURE_FILE_PATH = "src/main/resources/files/pictures.json";
    private final PictureRepository pictureRepository;

    private final Gson gson;

    private final ModelMapper modelMapper;

    private final ValidationUtils validationUtils;

    public PictureServiceImpl(PictureRepository pictureRepository, Gson gson, ModelMapper modelMapper, ValidationUtils validationUtils) {
        this.pictureRepository = pictureRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return this.pictureRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(PICTURE_FILE_PATH));
    }

    @Override
    public String importPictures() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        Arrays.stream(gson.fromJson(readFromFileContent(), PicturesImportDto[].class))
                .filter(picturesImportDto -> {
                    boolean isValid = validationUtils.isValid(picturesImportDto);

                    if (this.pictureRepository.findByPath(picturesImportDto.getPath()).isPresent()) isValid = false;

                    stringBuilder.append(isValid
                            ? String.format(SUCCESSFUL_FORMAT, PICTURE + ",", "with size", String.format("%.2f", picturesImportDto.getSize()))
                            : String.format(INVALID_FORMAT, PICTURE));

                    stringBuilder.append(System.lineSeparator());
                    return isValid;
                })
                .map(picture -> modelMapper.map(picture, Picture.class))
                .forEach(this.pictureRepository::save);

        return stringBuilder.toString().trim();
    }

    @Override
    public String exportPictures() {


        return null;
    }
}
