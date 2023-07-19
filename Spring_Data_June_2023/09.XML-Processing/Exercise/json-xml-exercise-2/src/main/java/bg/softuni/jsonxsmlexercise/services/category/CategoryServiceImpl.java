package bg.softuni.jsonxsmlexercise.services.category;

import bg.softuni.jsonxsmlexercise.domein.models.category.CategorySummeryModel;
import bg.softuni.jsonxsmlexercise.domein.models.category.wrappers.CategorySummeryWrapper;
import bg.softuni.jsonxsmlexercise.repositories.CategoryRepository;
import jakarta.xml.bind.JAXBException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

import static bg.softuni.jsonxsmlexercise.constant.Paths.THIRD_JSON_PATH;
import static bg.softuni.jsonxsmlexercise.constant.Paths.THIRD_XML_PATH;
import static bg.softuni.jsonxsmlexercise.constant.Utils.writeIntoJsonFile;
import static bg.softuni.jsonxsmlexercise.constant.Utils.writeIntoXmlFile;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategorySummeryModel> getCategorySummery() throws IOException, JAXBException {
        final List<CategorySummeryModel> categorySummaries =
                this.categoryRepository.getCategorySummery();

        CategorySummeryWrapper categorySummeryWrapper = new CategorySummeryWrapper(categorySummaries);

        writeIntoXmlFile(categorySummeryWrapper,THIRD_XML_PATH);

        writeIntoJsonFile(categorySummaries, THIRD_JSON_PATH);

        return categorySummaries;
    }

}

