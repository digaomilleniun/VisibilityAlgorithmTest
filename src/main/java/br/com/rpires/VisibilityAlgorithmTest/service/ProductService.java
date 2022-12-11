package br.com.rpires.VisibilityAlgorithmTest.service;

import br.com.rpires.VisibilityAlgorithmTest.domain.Product;
import br.com.rpires.VisibilityAlgorithmTest.exception.InvalidFileException;
import br.com.rpires.VisibilityAlgorithmTest.factory.DomainFactory;
import br.com.rpires.VisibilityAlgorithmTest.helper.CSVHelper;
import br.com.rpires.VisibilityAlgorithmTest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProductService {

    private ProductRepository productRepository;

    private CSVHelper<Product> csvHelper;

    @Autowired
    public ProductService(ProductRepository productRepository,
                          @Qualifier("productFactory") DomainFactory<Product> domainFactory) {
        this.productRepository = productRepository;
        this.csvHelper = new CSVHelper(domainFactory);
    }

    public void upload(MultipartFile file) {
        Iterable<Product> it = readAndCreate(file);
        productRepository.saveAll(it);
    }

    private Iterable<Product> readAndCreate(MultipartFile file) {
        if (!csvHelper.hasCSVFormat(file)) {
            throw new InvalidFileException("INVALID FILE.", HttpStatus.BAD_REQUEST);
        }
        return csvHelper.readFile(file);
    }

    public Page<Product> findAll(Integer page, Integer size) {
        return productRepository.findAll(PageRequest.of(page, size));
    }
}
