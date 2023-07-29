package exam.model.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BaseShopDto {

    @NotNull
    @Size(min = 4)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
