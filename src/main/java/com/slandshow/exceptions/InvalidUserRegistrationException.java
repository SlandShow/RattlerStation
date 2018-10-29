package com.slandshow.exceptions;

public class InvalidUserRegistrationException extends BusinessLogicException {

    public InvalidUserRegistrationException(String errorMessage) {
        super(errorMessage);
    }

    public InvalidUserRegistrationException(String error, String errorMessage) {
        super(error, errorMessage);
    }

}
