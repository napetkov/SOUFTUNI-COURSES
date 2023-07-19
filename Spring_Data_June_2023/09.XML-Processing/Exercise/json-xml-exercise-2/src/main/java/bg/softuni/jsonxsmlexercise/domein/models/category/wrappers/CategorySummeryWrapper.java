package bg.softuni.jsonxsmlexercise.domein.models.category.wrappers;

import bg.softuni.jsonxsmlexercise.domein.models.category.CategorySummeryModel;
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
@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategorySummeryWrapper {

    @XmlElement(name = "category")
    private List<CategorySummeryModel> categories;
}
