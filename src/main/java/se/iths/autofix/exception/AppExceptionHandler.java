package se.iths.autofix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = BadInputFormatException.class)
    public ResponseEntity<Object> handleException(BadInputFormatException e){

     //   return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        return new ResponseEntity(e.getMsg(),HttpStatus.BAD_REQUEST);
    }
}
