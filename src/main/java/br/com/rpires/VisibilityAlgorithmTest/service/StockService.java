package br.com.rpires.VisibilityAlgorithmTest.service;

import br.com.rpires.VisibilityAlgorithmTest.domain.Size;
import br.com.rpires.VisibilityAlgorithmTest.domain.Stock;
import br.com.rpires.VisibilityAlgorithmTest.exception.InvalidFileException;
import br.com.rpires.VisibilityAlgorithmTest.factory.DomainFactory;
import br.com.rpires.VisibilityAlgorithmTest.helper.CSVHelper;
import br.com.rpires.VisibilityAlgorithmTest.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StockService {

    private StockRepository stockRepository;

    private CSVHelper csvHelper;

    @Autowired
    public StockService(StockRepository stockRepository,
                       @Qualifier("stockFactory") DomainFactory<Stock> domainFactory) {
        this.stockRepository = stockRepository;
        this.csvHelper = new CSVHelper(domainFactory);
    }

    public void upload(MultipartFile file) {
        Iterable<Stock> it = readAndCreate(file);
        stockRepository.saveAll(it);
    }

    private Iterable<Stock> readAndCreate(MultipartFile file) {
        if (!csvHelper.hasCSVFormat(file)) {
            throw new InvalidFileException("INVALID FILE.", HttpStatus.BAD_REQUEST);
        }
        return csvHelper.readFile(file);
    }

    public Page<Stock> findAll(Integer page, Integer size) {
        return stockRepository.findAll(PageRequest.of(page, size));
    }
}
