package se.iths.autofix.exception;

public class ClientNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private String msg;

    public ClientNotFoundException(String msg){
        this.msg = msg;
    }

    public String getMsg(){
        return msg;
    }
}