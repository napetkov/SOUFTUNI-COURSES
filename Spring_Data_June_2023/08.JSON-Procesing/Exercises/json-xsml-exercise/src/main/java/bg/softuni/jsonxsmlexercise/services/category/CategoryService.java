package bg.softuni.jsonxsmlexercise.services.category;

import bg.softuni.jsonxsmlexercise.domein.models.CategorySummeryDTO;
import bg.softuni.jsonxsmlexercise.domein.models.ProductBaseInfoWithSellerFullNameModel;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface CategoryService {
    List<CategorySummeryDTO> getCategorySummery() throws IOException;

}
