package softuni.exam.instagraphlite.models.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "post")
@XmlAccessorType(XmlAccessType.FIELD)
public class PostImportDto {
    @XmlElement(name = "caption")
    @NotNull
    @Size(min = 21)
    private String caption;

    @NotNull
    @XmlElement(name = "user")
    private BaseUserDto user;

    @NotNull
    @XmlElement(name = "picture")
    private BasePictureDto picture;

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public BaseUserDto getUser() {
        return user;
    }

    public void setUser(BaseUserDto user) {
        this.user = user;
    }

    public BasePictureDto getPicture() {
        return picture;
    }

    public void setPicture(BasePictureDto picture) {
        this.picture = picture;
    }
}
