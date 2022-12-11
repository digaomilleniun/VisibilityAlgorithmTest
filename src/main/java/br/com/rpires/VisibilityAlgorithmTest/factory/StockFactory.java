package br.com.rpires.VisibilityAlgorithmTest.factory;

import br.com.rpires.VisibilityAlgorithmTest.domain.Size;
import br.com.rpires.VisibilityAlgorithmTest.domain.Stock;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

@Component(value = "stockFactory")
public class StockFactory implements DomainFactory<Stock>{

    @Override
    public Stock createDomain(CSVRecord record) {
        return Stock.builder()
                .sizeId(Long.parseLong(record.get(0).trim()))
                .quantity(Long.parseLong(record.get(1).trim()))
                .build();
    }
}