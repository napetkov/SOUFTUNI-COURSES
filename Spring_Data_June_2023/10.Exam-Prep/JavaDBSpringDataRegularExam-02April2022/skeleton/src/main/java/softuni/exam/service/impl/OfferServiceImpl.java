package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.OfferExportDto;
import softuni.exam.models.dto.OfferImportDto;
import softuni.exam.models.dto.OfferImportWrapperDto;
import softuni.exam.models.entity.ApartmentType;
import softuni.exam.models.entity.Offer;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.OfferService;
import softuni.exam.util.ValidationUtils;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

import static softuni.exam.models.Constant.*;

@Service
public class OfferServiceImpl implements OfferService {

    private static final String OFFERS_FILE_PATH = "src/main/resources/files/xml/offers.xml";

    private final OfferRepository offerRepository;
    private final ModelMapper mapper;
    private final ValidationUtils validationUtils;
    private final XmlParser xmlParser;
    private final AgentRepository agentRepository;
    private final ApartmentRepository apartmentRepository;

    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper mapper, ValidationUtils validationUtils, XmlParser xmlParser, AgentRepository agentRepository, ApartmentRepository apartmentRepository) {
        this.offerRepository = offerRepository;
        this.mapper = mapper;
        this.validationUtils = validationUtils;
        this.xmlParser = xmlParser;
        this.agentRepository = agentRepository;
        this.apartmentRepository = apartmentRepository;
    }

    @Override
    public boolean areImported() {
        return this.offerRepository.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return Files.readString(Path.of(OFFERS_FILE_PATH));
    }

    @Override
    public String importOffers() throws IOException, JAXBException {
        StringBuilder stringBuilder = new StringBuilder();

        List<OfferImportDto> offers = xmlParser.fromFile(Path.of(OFFERS_FILE_PATH).toFile(), OfferImportWrapperDto.class).getOffers().stream().toList();

        for (OfferImportDto offer : offers) {
            stringBuilder.append(System.lineSeparator());

            if (this.agentRepository.findFirstByFirstName(offer.getAgent().getName()).isEmpty()
                    || !validationUtils.isValid(offer)) {
                stringBuilder.append(String.format(INVALID_FORMAT,OFFER));

                continue;
            }

            Offer offerToSave = mapper.map(offer, Offer.class);
            offerToSave.setAgent(this.agentRepository.findFirstByFirstName(offer.getAgent().getName()).get());
            offerToSave.setApartment(this.apartmentRepository.findById(offer.getApartment().getId()).get());

            this.offerRepository.save(offerToSave);

            stringBuilder.append(String.format(SUCCESSFUL_FORMAT,OFFER,offerToSave.getPrice().setScale(2),""));


        }


        return stringBuilder.toString().trim();
    }

    @Override
    public String exportOffers() {
      return this.offerRepository
                .findAllByApartmentApartmentTypeOrderByApartmentAreaDescPriceAsc(ApartmentType.three_rooms)
                .stream().map(offer -> mapper.map(offer,OfferExportDto.class))
              .map(OfferExportDto::toString)
              .collect(Collectors.joining("\n"));

    }
}
