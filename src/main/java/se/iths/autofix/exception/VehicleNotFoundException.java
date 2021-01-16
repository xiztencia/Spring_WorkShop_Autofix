package se.iths.autofix.exception;

public class VehicleNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private String msg;

    public VehicleNotFoundException(String msg){
        this.msg = msg;
    }

    public String getMsg(){
        return msg;
    }
}
