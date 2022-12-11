package br.com.rpires.VisibilityAlgorithmTest.helper;

import br.com.rpires.VisibilityAlgorithmTest.exception.CSVFileReadException;
import br.com.rpires.VisibilityAlgorithmTest.factory.DomainFactory;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.http.HttpStatus;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVHelper<T> {

    private static String TYPE = "text/csv";
    private final DomainFactory<T> domainFactory;

    public CSVHelper(DomainFactory<T> domainFactory) {
        this.domainFactory = domainFactory;
    }

    public boolean hasCSVFormat(MultipartFile file) {
        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }

    public Iterable<T> readFile(MultipartFile file) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(file.getInputStream(), "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT);) {

            List<T> list = new ArrayList<T>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            csvRecords.forEach(record-> list.add(domainFactory.createDomain(record)));

            return list;
        } catch (IOException e) {
            throw new CSVFileReadException("Fail to parse CSV file", e);
        } catch (IllegalStateException e) {
            throw new CSVFileReadException(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            throw new CSVFileReadException(e.getMessage(), e);
        }
    }
}
