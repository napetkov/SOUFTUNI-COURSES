package com.example.football.models.dto;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "stats")
@XmlAccessorType(XmlAccessType.FIELD)
public class StatImportWrapperDto {
    @XmlElement(name = "stat")
    private List<StatImportDto> stats;

    public List<StatImportDto> getStats() {
        return stats;
    }

    public void setStats(List<StatImportDto> stats) {
        this.stats = stats;
    }
}
