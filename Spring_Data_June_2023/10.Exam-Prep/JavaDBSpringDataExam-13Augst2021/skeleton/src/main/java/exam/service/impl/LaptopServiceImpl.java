package exam.service.impl;

import com.google.gson.Gson;
import exam.model.dto.LaptopExportDto;
import exam.model.dto.LaptopImportDto;
import exam.model.entity.Laptop;
import exam.model.entity.Shop;
import exam.model.entity.WarrantyType;
import exam.repository.LaptopRepository;
import exam.repository.ShopRepository;
import exam.service.LaptopService;
import exam.util.ValidationUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static exam.model.Constants.*;

@Service
public class LaptopServiceImpl implements LaptopService {
    private static final String LAPTOPS_FILE_PATH = "src/main/resources/files/json/laptops.json";

    private final LaptopRepository laptopRepository;
    private final ShopRepository shopRepository;
    private final Gson gson;
    private final ValidationUtils validationUtils;

    private final ModelMapper modelMapper;

    public LaptopServiceImpl(LaptopRepository laptopRepository, ShopRepository shopRepository, Gson gson, ValidationUtils validationUtils, ModelMapper modelMapper) {
        this.laptopRepository = laptopRepository;
        this.shopRepository = shopRepository;
        this.gson = gson;
        this.validationUtils = validationUtils;
        this.modelMapper = modelMapper;
    }


    @Override
    public boolean areImported() {
        return this.laptopRepository.count() > 0;
    }

    @Override
    public String readLaptopsFileContent() throws IOException {
        return Files.readString(Path.of(LAPTOPS_FILE_PATH));
    }

    @Override
    public String importLaptops() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        List<LaptopImportDto> laptops = Arrays.stream(gson.fromJson(readLaptopsFileContent(), LaptopImportDto[].class)).toList();

        for (LaptopImportDto laptop : laptops) {
            stringBuilder.append(System.lineSeparator());

            Optional<Shop> shop = this.shopRepository.findFirstByName(laptop.getShop().getName());

            if (this.laptopRepository.findFirstByMacAddress(laptop.getMacAddress()).isPresent()
                    ||shop.isEmpty()
                    || !validationUtils.isValid(laptop)) {
                stringBuilder.append(String.format(INVALID_FORMAT,LAPTOP));

                continue;
            }

            Laptop laptopToSave = modelMapper.map(laptop, Laptop.class);
            laptopToSave.setShop(shop.get());

            this.laptopRepository.save(laptopToSave);

            stringBuilder.append(String.format(SUCCESSFUL_FORMAT,
                    LAPTOP,
                    laptop.getMacAddress(),
                    String.format("- %.2f - %d - %d",
                            laptop.getCpuSpeed(),
                            laptop.getRam(),
                            laptop.getStorage())));
        }


        return stringBuilder.toString().trim();

    }

    @Override
    public String exportBestLaptops() {
        return this.laptopRepository.findAllByOrderByCpuSpeedDescRamDescStorageDescMacAddressAsc()
                .stream().map(laptop -> modelMapper.map(laptop, LaptopExportDto.class))
                .map(LaptopExportDto::toString)
                .collect(Collectors.joining("/n"));


    }
}
