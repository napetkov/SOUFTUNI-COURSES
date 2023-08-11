package softuni.exam.models.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "tickets")
@XmlAccessorType(XmlAccessType.FIELD)
public class TicketWrapperImportDto {

    @XmlElement(name = "ticket")
    List<TicketImportDto> tickets;

    public List<TicketImportDto> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketImportDto> tickets) {
        this.tickets = tickets;
    }
}
