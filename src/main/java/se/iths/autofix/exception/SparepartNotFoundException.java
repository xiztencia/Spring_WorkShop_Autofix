package se.iths.autofix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Spare part Not Found")
public class SparepartNotFoundException extends Exception{
    private static final long serialVersionUID = 1L;
    public SparepartNotFoundException(String message) {
        super(message);
    }
}
