package bg.softuni.jsonxsmlexercise.services.product;

import bg.softuni.jsonxsmlexercise.domein.models.ProductBaseInfoWithSellerFullNameModel;
import bg.softuni.jsonxsmlexercise.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import static bg.softuni.jsonxsmlexercise.constant.Paths.FIRST_JSON_PATH;
import static bg.softuni.jsonxsmlexercise.constant.Utils.writeIntoJsonFile;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductBaseInfoWithSellerFullNameModel> productsInRangeWithNoBuyer(BigDecimal lowBoundary, BigDecimal highBoundary) throws IOException {
        final List<ProductBaseInfoWithSellerFullNameModel> products =
                this.productRepository.findAllByPriceBetweenAndBuyerIsNullOrderByPrice(lowBoundary, highBoundary)
                        .stream().map(ProductBaseInfoWithSellerFullNameModel::getFromProduct)
                        .toList();

        writeIntoJsonFile(products, FIRST_JSON_PATH);

        return products;
    }


}
