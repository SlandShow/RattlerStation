package com.slandshow.exceptions;

public class BusinessLogicException extends Exception {

    private String error;

    private String errorMessage;

    public BusinessLogicException(String errorMessage){
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public BusinessLogicException(String error, String errorMessage){
        super(errorMessage);
        this.error = error;
        this.errorMessage = errorMessage;
    }

    // Getters

    public String getError() {
        return error;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
