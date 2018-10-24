package com.slandshow.exceptions;

public class InvalidTrainException extends BusinessLogicException {

    public InvalidTrainException(String errorMessage) {
        super(errorMessage);
    }

    public InvalidTrainException(String error, String errorMessage) {
        super(error, errorMessage);
    }

}
