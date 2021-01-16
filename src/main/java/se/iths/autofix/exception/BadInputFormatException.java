package se.iths.autofix.exception;

public class BadInputFormatException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private String msg;

    public BadInputFormatException(String msg){
        this.msg = msg;
    }

    public String getMsg(){
        return msg;
    }
}
