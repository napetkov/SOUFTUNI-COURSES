package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.PartImportDto;
import softuni.exam.models.entity.Part;
import softuni.exam.repository.PartsRepository;
import softuni.exam.service.PartsService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static softuni.exam.models.Constant.*;
// TODO: Implement all methods

@Service
public class PartsServiceImpl implements PartsService {

    private static final String PARTS_FILE_PATH = "C:\\Users\\35988\\Desktop\\Nikolay_Petkov\\SOFTUNI\\SOUFTUNI-COURSES\\Spring_Data_June_2023\\10.Exam-Prep\\JavaDBSpringDataRegularExam-03December2022\\skeleton\\src\\main\\resources\\files\\json\\parts.json";
    private final PartsRepository partsRepository;
    private final ValidationUtils validationUtils;
    private final ModelMapper mapper;
    private final Gson gson;

    @Autowired
    public PartsServiceImpl(PartsRepository partsRepository, ValidationUtils validationUtils, ModelMapper mapper, Gson gson) {
        this.partsRepository = partsRepository;
        this.validationUtils = validationUtils;
        this.mapper = mapper;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return this.partsRepository.count() > 0;
    }

    @Override
    public String readPartsFileContent() throws IOException {
        return Files.readString(Path.of(PARTS_FILE_PATH));
    }

    @Override
    public String importParts() throws IOException {
        final StringBuilder stringBuilder = new StringBuilder();

        List<PartImportDto> parts = Arrays.stream(this.gson.fromJson(this.readPartsFileContent(), PartImportDto[].class))
                .collect(Collectors.toList());

        for (PartImportDto part : parts) {
            stringBuilder.append(System.lineSeparator());

            if (this.partsRepository.findFirstByPartName(part.getPartName()).isPresent() || !this.validationUtils.isValid(part)) {
                stringBuilder.append(String.format(INVALID_FORMAT,PART));
                continue;
            }

                this.partsRepository.save(mapper.map(part,Part.class));

                stringBuilder.append(String.format(SUCCESSFUL_FORMAT,
                        PART,
                        part.getPartName() + " -",
                        part.getPrice()));
        }



        return stringBuilder.toString().trim();
    }
}
