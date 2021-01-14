package se.iths.autofix.exception;

//@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Vehicle Not Found")
public class VehicleNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private String msg;

    public VehicleNotFoundException(String msg){
        this.msg = msg;

        //public BadInputFormatException(String errorMessage) {
        //    super(errorMessage);
    }

    public String getMsg(){
        return msg;
    }

//    public VehicleNotFoundException(String message) {
//        super(message);
//    }
}
