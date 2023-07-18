package bg.softuni.jsonxsmlexercise.domein.models.user.wrappers;

import bg.softuni.jsonxsmlexercise.domein.models.user.UserImportModel;
import lombok.Getter;
import lombok.Setter;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Getter
@Setter
@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserWrapperImportModel {

    @XmlElement(name = "user")
    private List<UserImportModel> users;
}
