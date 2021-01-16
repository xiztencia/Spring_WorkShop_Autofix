package se.iths.autofix.exception;

public class MaintenanceNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private String msg;

    public MaintenanceNotFoundException(String msg){
        this.msg = msg;
    }

    public String getMsg(){
        return msg;
    }
}
