package br.com.rpires.VisibilityAlgorithmTest.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class InvalidFileException extends RuntimeException {

    private HttpStatus status;

    public InvalidFileException(String message) {
        super(message);
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public InvalidFileException(String message, Exception e) {
        super(message, e);
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public InvalidFileException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
