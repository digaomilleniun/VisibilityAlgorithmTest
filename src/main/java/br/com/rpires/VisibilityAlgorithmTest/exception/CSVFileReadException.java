package br.com.rpires.VisibilityAlgorithmTest.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CSVFileReadException extends RuntimeException {

    private HttpStatus status;

    public CSVFileReadException(String message) {
        super(message);
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public CSVFileReadException(String message, Exception e) {
        super(message, e);
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public CSVFileReadException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
