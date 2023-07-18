package bg.softuni.jsonxsmlexercise.domein.models.product.wrappers;

import bg.softuni.jsonxsmlexercise.domein.models.product.ProductImportModel;
import lombok.Getter;
import lombok.Setter;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Getter
@Setter
@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductWrapperImportModel {

    @XmlElement(name = "product")
    private List<ProductImportModel> products;
}
