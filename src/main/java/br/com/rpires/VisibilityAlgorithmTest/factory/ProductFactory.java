package br.com.rpires.VisibilityAlgorithmTest.factory;

import br.com.rpires.VisibilityAlgorithmTest.domain.Product;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

@Component(value = "productFactory")
public class ProductFactory implements DomainFactory<Product>{

    @Override
    public Product createDomain(CSVRecord record) {
        return Product.builder()
                .id(Long.parseLong(record.get(0).trim()))
                .sequence(record.get(1))
                .build();
    }
}
