package se.iths.autofix.exception;

//@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE, reason = "Input is not correct")

public class BadInputFormatException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private String msg;


    public BadInputFormatException(String msg){
        this.msg = msg;

    //public BadInputFormatException(String errorMessage) {
    //    super(errorMessage);
    }


    public String getMsg(){
        return msg;
    }
}
