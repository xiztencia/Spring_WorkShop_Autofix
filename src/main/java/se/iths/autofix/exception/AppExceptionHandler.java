package se.iths.autofix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = BadInputFormatException.class)
    public ResponseEntity<Object> handleException(BadInputFormatException e){
        return new ResponseEntity(e.getMsg(),HttpStatus.BAD_REQUEST);
    }

    @ResponseBody
    @ExceptionHandler(value = ClientNotFoundException.class)
    public ResponseEntity<Object> handleException(ClientNotFoundException e){
        return new ResponseEntity(e.getMsg(),HttpStatus.NOT_FOUND);
    }

    @ResponseBody
    @ExceptionHandler(value = EmployeeNotFoundException.class)
    public ResponseEntity<Object> handleException(EmployeeNotFoundException e){
        return new ResponseEntity(e.getMsg(),HttpStatus.NOT_FOUND);
    }

    @ResponseBody
    @ExceptionHandler(value = MaintenanceNotFoundException.class)
    public ResponseEntity<Object> handleException(MaintenanceNotFoundException e){
        return new ResponseEntity(e.getMsg(),HttpStatus.NOT_FOUND);
    }

    @ResponseBody
    @ExceptionHandler(value = SparepartNotFoundException.class)
    public ResponseEntity<Object> handleException(SparepartNotFoundException e){
        return new ResponseEntity(e.getMsg(),HttpStatus.NOT_FOUND);
    }

    @ResponseBody
    @ExceptionHandler(value = VehicleNotFoundException.class)
    public ResponseEntity<Object> handleException(VehicleNotFoundException e){
        return new ResponseEntity(e.getMsg(),HttpStatus.NOT_FOUND);
    }
}
