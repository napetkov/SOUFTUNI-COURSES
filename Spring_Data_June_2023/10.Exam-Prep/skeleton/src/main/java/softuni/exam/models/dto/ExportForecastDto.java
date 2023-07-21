package softuni.exam.models.dto;

public class ExportForecastDto {
    private CityBasic city;
    private String minTemperature;
    private String maxTemperature;
    private String sunrise;
    private String sunset;

    public CityBasic getCity() {
        return city;
    }

    public void setCity(CityBasic city) {
        this.city = city;
    }

    public String getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(String minTemperature) {
        this.minTemperature = minTemperature;
    }

    public String getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(String maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    @Override
    public String toString() {
        return String.format("City: %s:%n\tmin temperature: %s%n\tmax temperature: %s%n\t---sunrise: %s%n\t----sunset: %s%n. . . %n",
                this.city.getCityName(),
                this.minTemperature,
                this.maxTemperature,
                this.sunrise,
                this.sunset);
    }
}
