package com.slandshow.exceptions;

public class ExceptionsInfo {

    /* Booking ticket exceptions messages */
    public static final String USER_ALREADY_ON_THIS_SEAT = "USER ALREADY ON THIS SEAT";
    public static final String USER_OR_SCHEDULE_NOT_EXISTS = "USER OR SCHEDULE IS NULL";
    public static final String SCHEDULE_NOT_AVAILABLE_NOW = "PROBLEM WITH SCHEDULE AVAILABILITY";
    public static final String SAME_USER_TRY_TO_BOOK_SEAT = "THIS USER ALREADY BOOKED SEAT";

    /* Create schedule exceptions messages */
    public static final String SCHEDULE_IS_NULL = "SCHEDULE IS NULL";
    public static final String TRAINS_STATIONS_ARE_NULL = "STATIONS OR TRAIN ARE NULL";
    public static final String STATIONS_ARE_THE_SAME = "STATION DEPARTURE AND STATION ARRIVAL ARE THE SAME";
    public static final String DATE_DEPARTURE_GREATER_THAN_ARRIVAL = "DATE DEPARTURE GREATER THAN DATE ARRIVAL";
    public static final String TRAIN_INTERSECTION = "TRAIN INTERSECTION BETWEEN SCHEDULES";
    public static final String SCHEDULE_CURRENT_DAY_CREATION = "CANNOT CREATE, BECAUSE DATE IS CURRENT DAY";
    public static final String DELETING_SCHEDULE_PROBLEM = "CURRENT SCHEDULE IS ALREADY DELETED";

}
