package br.com.rpires.VisibilityAlgorithmTest.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
public class InvalidPropertyException extends RuntimeException {

    private HttpStatus status;

    public InvalidPropertyException(String message) {
        super(message);
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public InvalidPropertyException(String message, Exception e) {
        super(message, e);
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public InvalidPropertyException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
