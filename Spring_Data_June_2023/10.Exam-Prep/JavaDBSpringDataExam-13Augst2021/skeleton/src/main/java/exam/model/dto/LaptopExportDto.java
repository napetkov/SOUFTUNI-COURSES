package exam.model.dto;

import java.math.BigDecimal;

public class LaptopExportDto {

    private String macAddress;

    private double cpuSpeed;

    private Integer ram;

    private Integer storage;

    private BigDecimal price;

    private String shopName;

    private String shopTownName;

    public LaptopExportDto() {
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public double getCpuSpeed() {
        return cpuSpeed;
    }

    public void setCpuSpeed(double cpuSpeed) {
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopTownName() {
        return shopTownName;
    }

    public void setShopTownName(String shopTownName) {
        this.shopTownName = shopTownName;
    }

    @Override
    public String toString() {
        return String.format("""
                        Laptop - %s
                        *Cpu speed - %.2f
                        **Ram - %d
                        ***Storage - %d
                        ****Price - %.2f
                        #Shop name - %s
                        ##Town - %s
                        . . .\s
                        """,
                this.macAddress,
                this.cpuSpeed,
                this.ram,
                this.storage,
                this.price,
                this.shopName,
                this.shopTownName);
    }
}
