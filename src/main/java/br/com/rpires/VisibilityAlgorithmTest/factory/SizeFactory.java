package br.com.rpires.VisibilityAlgorithmTest.factory;

import br.com.rpires.VisibilityAlgorithmTest.domain.Size;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

@Component(value = "sizeFactory")
public class SizeFactory implements DomainFactory<Size>{

    @Override
    public Size createDomain(CSVRecord record) {
        return Size.builder()
                .id(Long.parseLong(record.get(0).trim()))
                .productId(Long.parseLong(record.get(1).trim()))
                .backSoon(Boolean.parseBoolean(record.get(2).trim()))
                .special(Boolean.parseBoolean(record.get(3).trim()))
                .build();
    }
}