package se.iths.autofix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Client Not Found")
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Client Not Found")
//public class ClientNotFoundException extends Exception {
public class ClientNotFoundException extends RuntimeException{
//    private static final long serialVersionUID = 1L;
//
//    public ClientNotFoundException(String message) {
//        super(message);
//    }
}