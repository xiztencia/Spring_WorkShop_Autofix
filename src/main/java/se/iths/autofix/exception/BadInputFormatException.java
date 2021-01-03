package se.iths.autofix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE, reason = "Input is not correct")
public class BadInputFormatException extends Exception {
    private static final long serialVersionUID = 1L;

    public BadInputFormatException(String errorMessage) {
        super(errorMessage);
    }
}