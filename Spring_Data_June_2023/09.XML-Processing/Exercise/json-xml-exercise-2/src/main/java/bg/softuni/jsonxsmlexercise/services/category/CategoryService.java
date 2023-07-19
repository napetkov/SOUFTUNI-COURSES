package bg.softuni.jsonxsmlexercise.services.category;

import bg.softuni.jsonxsmlexercise.domein.models.category.CategorySummeryModel;
import jakarta.xml.bind.JAXBException;

import java.io.IOException;
import java.util.List;

public interface CategoryService {
    List<CategorySummeryModel> getCategorySummery() throws IOException, JAXBException;

}
