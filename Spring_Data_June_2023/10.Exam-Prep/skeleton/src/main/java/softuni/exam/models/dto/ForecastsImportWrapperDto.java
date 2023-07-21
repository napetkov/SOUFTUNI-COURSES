package softuni.exam.models.dto;

import softuni.exam.models.entity.Forecast;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "forecasts")
@XmlAccessorType(XmlAccessType.FIELD)
public class ForecastsImportWrapperDto {

    @XmlElement(name = "forecast")
    private List<ForecastDto> forecasts;

    public List<ForecastDto> getForecasts() {
        return forecasts;
    }

    public void setForecasts(List<ForecastDto> forecasts) {
        this.forecasts = forecasts;
    }
}
