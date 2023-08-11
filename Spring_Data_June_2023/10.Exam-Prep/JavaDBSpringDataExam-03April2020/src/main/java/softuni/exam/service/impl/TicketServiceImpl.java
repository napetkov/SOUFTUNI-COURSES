package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.TicketWrapperImportDto;
import softuni.exam.models.entitnies.Passenger;
import softuni.exam.models.entitnies.Plane;
import softuni.exam.models.entitnies.Ticket;
import softuni.exam.models.entitnies.Town;
import softuni.exam.repository.PassengerRepository;
import softuni.exam.repository.PlaneRepository;
import softuni.exam.repository.TicketRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TicketService;
import softuni.exam.util.ValidationUtils;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static softuni.exam.models.Constants.*;

@Service
public class TicketServiceImpl implements TicketService {
    private final String TICKET_FILE_PATH = "src/main/resources/files/xml/tickets.xml";
    private final TicketRepository ticketRepository;
    private final TownRepository townRepository;
    private final PlaneRepository planeRepository;
    private final PassengerRepository passengerRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtils validationUtils;

    public TicketServiceImpl(
            TicketRepository ticketRepository,
            TownRepository townRepository,
            PlaneRepository planeRepository,
            PassengerRepository passengerRepository, XmlParser xmlParser,
            ModelMapper modelMapper,
            ValidationUtils validationUtils) {
        this.ticketRepository = ticketRepository;
        this.townRepository = townRepository;
        this.planeRepository = planeRepository;
        this.passengerRepository = passengerRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return this.ticketRepository.count() > 0;
    }

    @Override
    public String readTicketsFileContent() throws IOException {
        return Files.readString(Path.of(TICKET_FILE_PATH));
    }

    @Override
    public String importTickets() throws JAXBException, FileNotFoundException {
        StringBuilder stringBuilder = new StringBuilder();

        xmlParser.fromFile(Path.of(TICKET_FILE_PATH).toFile(), TicketWrapperImportDto.class)
                .getTickets()
                .stream().filter(ticketImportDto -> {
                    boolean isValid = validationUtils.isValid(ticketImportDto);

                    stringBuilder.append(isValid
                            ? String.format(SUCCESSFUL_FORMAT, TICKET,
                            ticketImportDto.getFromTown().getName() + " -",
                            ticketImportDto.getToTown().getName())
                            : String.format(INVALID_FORMAT, TICKET));

                    stringBuilder.append(System.lineSeparator());

                    return isValid;
                })
                .map(ticketToSave -> {

                    Town fromTown = this.townRepository.findFirstByName(ticketToSave.getFromTown().getName()).orElse(null);
                    Town toTown = this.townRepository.findFirstByName(ticketToSave.getToTown().getName()).orElse(null);

                    Passenger passenger = this.passengerRepository.findByEmail(ticketToSave.getPassenger().getEmail()).orElse(null);

                    Plane plane = this.planeRepository.findByRegisterNumber(ticketToSave.getPlane().getRegisterNumber()).orElse(null);


                    Ticket ticket = modelMapper.map(ticketToSave, Ticket.class);

                    ticket.setFromTown(fromTown);
                    ticket.setToTown(toTown);
                    ticket.setPassenger(passenger);
                    ticket.setPlane(plane);

                    return ticket;
                })
                .forEach(ticketRepository::save);

        return stringBuilder.toString().trim();
    }
}
