package se.iths.autofix.exception;

public class EmployeeNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private String msg;

    public EmployeeNotFoundException(String msg){
        this.msg = msg;
    }

    public String getMsg(){
        return msg;
    }
}
