package se.iths.autofix.exception;

//@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Employee Not Found")
public class EmployeeNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private String msg;

    public EmployeeNotFoundException(String msg){
        this.msg = msg;

        //public BadInputFormatException(String errorMessage) {
        //    super(errorMessage);
    }

    public String getMsg(){
        return msg;
    }

//    public EmployeeNotFoundException(String message) {
//        super(message);
//    }
}
