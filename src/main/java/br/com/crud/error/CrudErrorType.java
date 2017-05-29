package br.com.crud.error;

public class CrudErrorType {

    private String errorMessage;
    
    public CrudErrorType(String errorMessage){
        this.errorMessage = errorMessage;
    }
 
    public String getErrorMessage() {
        return errorMessage;
    }
 
}
