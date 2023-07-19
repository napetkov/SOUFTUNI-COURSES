package bg.softuni.jsonxsmlexercise.domein.models.user.wrappers;

import bg.softuni.jsonxsmlexercise.domein.models.user.UserWithSoldProducts;
import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersWithSoldProductsWrapperModel {

    @XmlAttribute(name = "count")
    private Integer count;

    @XmlElement(name = "user")
    private List<UserWithSoldProducts> users;

    public UsersWithSoldProductsWrapperModel(List<UserWithSoldProducts> users) {
        this.users = users;
        this.count = users.size();
    }
}
