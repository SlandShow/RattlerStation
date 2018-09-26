package com.slandshow.exceptions;

public class ScheduleCreationException extends BookingTicketException {

    public ScheduleCreationException(String errorMessage) {
        super(errorMessage);
    }

    public ScheduleCreationException(String error, String errorMessage) {
        super(error, errorMessage);
    }

}
