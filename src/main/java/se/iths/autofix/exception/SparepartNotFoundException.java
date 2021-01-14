package se.iths.autofix.exception;

//@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Spare part Not Found")
public class SparepartNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private String msg;

    public SparepartNotFoundException(String msg){
        this.msg = msg;

        //public BadInputFormatException(String errorMessage) {
        //    super(errorMessage);
    }

    public String getMsg(){
        return msg;
    }

//    public SparepartNotFoundException(String message) {
//        super(message);
//    }
}
