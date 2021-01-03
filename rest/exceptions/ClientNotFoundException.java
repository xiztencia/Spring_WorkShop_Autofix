package se.iths.autofix.rest.exceptions;


@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Client Not Found")
public class ClientNotFoundException extends Exception {
    public ClientNotFoundException(String message) {
        super(message);
    }
}
