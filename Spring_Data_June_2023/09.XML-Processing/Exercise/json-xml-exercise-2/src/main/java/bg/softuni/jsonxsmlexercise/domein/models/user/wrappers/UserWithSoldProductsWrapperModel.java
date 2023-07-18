package bg.softuni.jsonxsmlexercise.domein.models.user.wrappers;

import bg.softuni.jsonxsmlexercise.domein.models.user.UserWithSoldProductsModel;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserWithSoldProductsWrapperModel {

    @XmlElement(name = "user")
    List<UserWithSoldProductsModel> users;
}
