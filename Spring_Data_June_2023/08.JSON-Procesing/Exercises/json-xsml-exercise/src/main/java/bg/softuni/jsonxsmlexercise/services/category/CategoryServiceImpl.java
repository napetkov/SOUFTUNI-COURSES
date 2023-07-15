package bg.softuni.jsonxsmlexercise.services.category;

import bg.softuni.jsonxsmlexercise.domein.models.CategorySummeryDTO;
import bg.softuni.jsonxsmlexercise.domein.models.ProductBaseInfoWithSellerFullNameModel;
import bg.softuni.jsonxsmlexercise.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import static bg.softuni.jsonxsmlexercise.constant.Paths.FIRST_JSON_PATH;
import static bg.softuni.jsonxsmlexercise.constant.Paths.THIRD_JSON_PATH;
import static bg.softuni.jsonxsmlexercise.constant.Utils.writeIntoJsonFile;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategorySummeryDTO> getCategorySummery() throws IOException {
        final List<CategorySummeryDTO> categories =
                this.categoryRepository.getCategorySummery();


        writeIntoJsonFile(categories, THIRD_JSON_PATH);

        return categories;
    }

}

