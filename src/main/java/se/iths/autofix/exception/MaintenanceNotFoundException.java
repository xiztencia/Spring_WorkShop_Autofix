package se.iths.autofix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Maintenance Not Found")
public class MaintenanceNotFoundException extends Exception{
    private static final long serialVersionUID = 1L;
    public MaintenanceNotFoundException(String message) {
        super(message);
    }
}
