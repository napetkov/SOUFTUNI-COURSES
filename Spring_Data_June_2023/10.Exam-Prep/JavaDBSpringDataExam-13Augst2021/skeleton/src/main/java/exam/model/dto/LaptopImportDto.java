package exam.model.dto;

import exam.model.entity.WarrantyType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.*;
import java.math.BigDecimal;

public class LaptopImportDto {

    @Size(min = 8)
    @NotNull
    private String macAddress;

    @Positive
    @NotNull
    private Double cpuSpeed;

    @NotNull
    @Min(value = 8)
    @Max(value = 128)
    private Integer ram;

    @NotNull
    @Min(value = 128)
    @Max(value = 1024)
    private Integer storage;

    @NotNull
    @Size(min = 10)
    private String description;

    @NotNull
    @Positive
    private BigDecimal price;

    @NotNull
    @Enumerated
    private WarrantyType warrantyType;

    @NotNull
    private BaseShopDto shop;

    public LaptopImportDto() {
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public Double getCpuSpeed() {
        return cpuSpeed;
    }

    public void setCpuSpeed(Double cpuSpeed) {
        this.cpuSpeed = cpuSpeed;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public Integer getStorage() {
        return storage;
    }

    public void setStorage(Integer storage) {
        this.storage = storage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public WarrantyType getWarrantyType() {
        return warrantyType;
    }

    public void setWarrantyType(WarrantyType warrantyType) {
        this.warrantyType = warrantyType;
    }

    public BaseShopDto getShop() {
        return shop;
    }

    public void setShop(BaseShopDto shop) {
        this.shop = shop;
    }
}
