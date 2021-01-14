package se.iths.autofix.exception;

//@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Client Not Found")
public class ClientNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private String msg;

    public ClientNotFoundException(String msg){
        this.msg = msg;

        //public BadInputFormatException(String errorMessage) {
        //    super(errorMessage);
    }

    public String getMsg(){
        return msg;
    }

//    public ClientNotFoundException(String message) {
//        super(message);
//    }
}