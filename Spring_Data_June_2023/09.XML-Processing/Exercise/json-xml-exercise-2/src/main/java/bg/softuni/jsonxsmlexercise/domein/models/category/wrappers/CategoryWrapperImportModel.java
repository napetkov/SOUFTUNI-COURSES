package bg.softuni.jsonxsmlexercise.domein.models.category.wrappers;

import bg.softuni.jsonxsmlexercise.domein.models.category.CategoryImportModel;
import lombok.Getter;
import lombok.Setter;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Getter
@Setter
@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryWrapperImportModel {

    @XmlElement(name = "category")
    private List<CategoryImportModel> categories;
}
