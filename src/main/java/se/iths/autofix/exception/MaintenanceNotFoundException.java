package se.iths.autofix.exception;

//@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Maintenance Not Found")
public class MaintenanceNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private String msg;

    public MaintenanceNotFoundException(String msg){
        this.msg = msg;

        //public BadInputFormatException(String errorMessage) {
        //    super(errorMessage);
    }

    public String getMsg(){
        return msg;
    }


//    public MaintenanceNotFoundException(String message) {
//        super(message);
//    }
}
