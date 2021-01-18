package se.iths.autofix.exception;

public class SparepartNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private String msg;

    public SparepartNotFoundException(String msg){
        this.msg = msg;
    }

    public String getMsg(){
        return msg;
    }
}
