package com.slandshow.exceptions;

public class BookingTicketException extends BusinessLogicException {

    public BookingTicketException(String errorMessage) {
        super(errorMessage);
    }

    public BookingTicketException(String error, String errorMessage) {
        super(error, errorMessage);
    }

}
