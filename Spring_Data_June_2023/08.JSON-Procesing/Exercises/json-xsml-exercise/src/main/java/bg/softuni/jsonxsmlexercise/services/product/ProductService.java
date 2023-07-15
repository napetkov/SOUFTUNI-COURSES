package bg.softuni.jsonxsmlexercise.services.product;

import bg.softuni.jsonxsmlexercise.domein.models.ProductBaseInfoWithSellerFullNameModel;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    List<ProductBaseInfoWithSellerFullNameModel> productsInRangeWithNoBuyer(BigDecimal lowBoundary, BigDecimal highBoundary) throws IOException;
}
