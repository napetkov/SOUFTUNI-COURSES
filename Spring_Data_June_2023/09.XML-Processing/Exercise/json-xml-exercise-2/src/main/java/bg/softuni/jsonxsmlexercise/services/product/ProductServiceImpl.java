package bg.softuni.jsonxsmlexercise.services.product;

import bg.softuni.jsonxsmlexercise.domein.models.product.ProductBaseInfoWithSellerFullNameModel;
import bg.softuni.jsonxsmlexercise.domein.models.product.wrappers.ProductBasicInfoWrapper;
import bg.softuni.jsonxsmlexercise.repositories.ProductRepository;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import static bg.softuni.jsonxsmlexercise.constant.Paths.FIRST_JSON_PATH;
import static bg.softuni.jsonxsmlexercise.constant.Paths.FIRST_XML_PATH;
import static bg.softuni.jsonxsmlexercise.constant.Utils.writeIntoJsonFile;
import static bg.softuni.jsonxsmlexercise.constant.Utils.writeIntoXmlFile;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductBaseInfoWithSellerFullNameModel> productsInRangeWithNoBuyer(BigDecimal lowBoundary, BigDecimal highBoundary) throws IOException, JAXBException {
        final List<ProductBaseInfoWithSellerFullNameModel> products =
                this.productRepository.findAllByPriceBetweenAndBuyerIsNullOrderByPrice(lowBoundary, highBoundary)
                        .stream().map(ProductBaseInfoWithSellerFullNameModel::getFromProduct)
                        .toList();

        final ProductBasicInfoWrapper wrapper = new ProductBasicInfoWrapper(products);

        final File file = FIRST_XML_PATH.toFile();

        final JAXBContext context = JAXBContext.newInstance(ProductBasicInfoWrapper.class);

        final Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);

        marshaller.marshal(wrapper,file);


        writeIntoJsonFile(products, FIRST_JSON_PATH);
        writeIntoXmlFile(wrapper, FIRST_JSON_PATH);

        return products;
    }


}
