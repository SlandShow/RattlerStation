package com.slandshow.exceptions;

public class InvalidStationException extends BusinessLogicException {

    public InvalidStationException(String errorMessage) {
        super(errorMessage);
    }

    public InvalidStationException(String error, String errorMessage) {
        super(error, errorMessage);
    }

}
