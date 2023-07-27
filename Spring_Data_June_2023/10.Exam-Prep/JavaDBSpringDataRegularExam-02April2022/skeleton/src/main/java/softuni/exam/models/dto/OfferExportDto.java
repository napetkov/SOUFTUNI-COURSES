package softuni.exam.models.dto;

import java.math.BigDecimal;

public class OfferExportDto {
    private String agentFirstName;
    private String agentLastName;
    private Long id;

    private Double apartmentArea;

    private String apartmentTownTownName;

    private BigDecimal price;

    public OfferExportDto() {
    }

    public String getAgentFirstName() {
        return agentFirstName;
    }

    public void setAgentFirstName(String agentFirstName) {
        this.agentFirstName = agentFirstName;
    }

    public String getAgentLastName() {
        return agentLastName;
    }

    public void setAgentLastName(String agentLastName) {
        this.agentLastName = agentLastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getApartmentArea() {
        return apartmentArea;
    }

    public void setApartmentArea(Double apartmentArea) {
        this.apartmentArea = apartmentArea;
    }

    public String getApartmentTownTownName() {
        return apartmentTownTownName;
    }

    public void setApartmentTownTownName(String apartmentTownTownName) {
        this.apartmentTownTownName = apartmentTownTownName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return String.format("Agent %s %s with offer №%d:\n\t\t-Apartment area: %.2f\n\t\t--Town: %s\n\t\t---Price: %.2f$\n. . . \n",
                this.agentFirstName,
                this.agentLastName,
                this.id,
                this.apartmentArea,
                this.apartmentTownTownName,
                this.price);
    }
}
