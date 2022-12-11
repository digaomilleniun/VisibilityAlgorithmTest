package br.com.rpires.VisibilityAlgorithmTest.factory;

import org.apache.commons.csv.CSVRecord;

public interface DomainFactory<T> {

    public T createDomain(CSVRecord csvRecord);
}
