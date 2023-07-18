package bg.softuni.jsonxsmlexercise.services.category;

import bg.softuni.jsonxsmlexercise.domein.models.category.CategorySummeryDTO;

import java.io.IOException;
import java.util.List;

public interface CategoryService {
    List<CategorySummeryDTO> getCategorySummery() throws IOException;

}
