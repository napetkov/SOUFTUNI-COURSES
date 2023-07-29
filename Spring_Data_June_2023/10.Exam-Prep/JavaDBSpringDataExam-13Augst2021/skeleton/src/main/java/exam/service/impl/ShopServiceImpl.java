package exam.service.impl;

import exam.model.dto.ShopImportDto;
import exam.model.dto.ShopImportWrapperDto;
import exam.model.entity.Shop;
import exam.model.entity.Town;
import exam.repository.ShopRepository;
import exam.repository.TownRepository;
import exam.service.ShopService;
import exam.util.ValidationUtils;
import exam.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

import static exam.model.Constants.*;

@Service
public class ShopServiceImpl implements ShopService {
    private static final String SHOPS_FILE_PATH = "src/main/resources/files/xml/shops.xml";
    private final ShopRepository shopRepository;
    private final TownRepository townRepository;
    private final XmlParser xmlParser;

    private final ValidationUtils validationUtils;

    private final ModelMapper modelMapper;

    public ShopServiceImpl(ShopRepository shopRepository, TownRepository townRepository, XmlParser xmlParser, ValidationUtils validationUtils, ModelMapper modelMapper) {
        this.shopRepository = shopRepository;
        this.townRepository = townRepository;
        this.xmlParser = xmlParser;
        this.validationUtils = validationUtils;
        this.modelMapper = modelMapper;
    }


    @Override
    public boolean areImported() {
        return this.shopRepository.count() > 0;
    }

    @Override
    public String readShopsFileContent() throws IOException {
        return Files.readString(Path.of(SHOPS_FILE_PATH));
    }

    @Override
    public String importShops() throws JAXBException, FileNotFoundException {
        StringBuilder stringBuilder = new StringBuilder();

        List<ShopImportDto> shops = xmlParser.fromFile(Path.of(SHOPS_FILE_PATH).toFile(), ShopImportWrapperDto.class)
                .getShops();

        for (ShopImportDto shop : shops) {
            stringBuilder.append(System.lineSeparator());

            Optional<Town> town = this.townRepository.findFirstByName(shop.getTown().getName());

            if (this.shopRepository.findFirstByName(shop.getName()).isPresent()
                    || town.isEmpty()
                    || !validationUtils.isValid(shop)) {
                stringBuilder.append(String.format(INVALID_FORMAT,SHOP));

                continue;
            }

            Shop shopToSave = modelMapper.map(shop, Shop.class);
            shopToSave.setTown(town.get());

            this.shopRepository.save(shopToSave);

            stringBuilder.append(String.format(SUCCESSFUL_FORMAT,SHOP,shop.getName()+" -",shop.getIncome()));

        }


        return stringBuilder.toString().trim();
    }
}
