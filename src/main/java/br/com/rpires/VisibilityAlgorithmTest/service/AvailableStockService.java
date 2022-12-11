package br.com.rpires.VisibilityAlgorithmTest.service;

import br.com.rpires.VisibilityAlgorithmTest.domain.Product;
import br.com.rpires.VisibilityAlgorithmTest.domain.Size;
import br.com.rpires.VisibilityAlgorithmTest.domain.Stock;
import br.com.rpires.VisibilityAlgorithmTest.repository.ProductRepository;
import br.com.rpires.VisibilityAlgorithmTest.repository.SizeRepository;
import br.com.rpires.VisibilityAlgorithmTest.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class AvailableStockService {

    private StockRepository stockRepository;

    private SizeRepository sizeRepository;

    private ProductRepository productRepository;

    @Autowired
    public AvailableStockService(StockRepository stockRepository,
                                 SizeRepository sizeRepository,
                                 ProductRepository productRepository) {
        this.stockRepository = stockRepository;
        this.sizeRepository = sizeRepository;
        this.productRepository = productRepository;

    }

    public Page<Product> findAllAvailable(Integer page, Integer size) {
        Collection<Stock> availableStock =  stockRepository.findAllAvailableByQuantityNot(0L);
        List<Long> sizeIds = availableStock.stream().map(Stock::getSizeId).toList();

        Collection<Size> availableSizes =  sizeRepository.findAllAvailableByIdInAndBackSoonTrue(sizeIds);
        List<Long> productIds = availableSizes.stream().map(Size::getProductId).toList();

        return productRepository.findAllAvailableByIdIn(productIds, PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "sequence")));
    }

}
