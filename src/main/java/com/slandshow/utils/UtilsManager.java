package com.slandshow.utils;

import org.joda.time.DateTime;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class UtilsManager {

    /* ====For correct buy tickets process==== */

    private static final int MIN_DELTA_TRANSFER = 15;
    private static final int MAX_DELTA_TRANSFER = 360;

    /* ====For date & time==== */

    public static Date getNextDay(String dateForNextDay) throws ParseException {
        Date date = parseToDate(dateForNextDay);
        Date newDate = new Date();
        newDate.setTime(date.getTime() + (long) 1000 * 24 * 60 * 60);
        return newDate;
    }

    public static Date getNextDay(Date date) {
        Date newDate = new Date();
        newDate.setTime(date.getTime() + (long) 1000 * 24 * 60 * 60);
        return newDate;
    }

    public static Date parseToDate(String date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.parse(date);
    }

    public static Date parseToDateTime(String date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.parse(date);
    }

    public static String parseFormatDateToString(String token) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
        Date date = (Date)formatter.parse(token);

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        String formatedDate = cal.get(Calendar.YEAR) + "-"
                + (cal.get(Calendar.MONTH) + 1) + "-"
                + cal.get(Calendar.DATE) + " "
                + cal.get(Calendar.HOUR) + ":"
                + cal.get(Calendar.MINUTE) + ":"
                +cal.get(Calendar.SECOND);

        return formatedDate;
    }

    public static String parseInputeTokenToValid(String inputToken) throws ParseException {
        String validToken = null;

        String[] tokens = inputToken.split(" ");

        if (tokens.length != 3)
            throw new ParseException("Tokens invalid", -1);

        String preToken = tokens[1].substring(0, 5);

        String firstSubTokens = tokens[0];
        String secondSubTokens = preToken + " " + tokens[2];

        String[] base = null;

        base = firstSubTokens.split("/");
        if (base.length != 3)
            throw new ParseException("Tokens invalid", -1);

        String day = base[0];
        String month = base[1];
        String year = base[2];

        SimpleDateFormat date12Format = new SimpleDateFormat("hh:mm a");

        SimpleDateFormat date24Format = new SimpleDateFormat("HH:mm");

        validToken = year + "-" + month + "-" + day + " " + date24Format.format(date12Format.parse(secondSubTokens)) + ":00";

        return validToken;
    }

    public static Date getTodayDateTime() throws ParseException {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        df.setTimeZone(TimeZone.getTimeZone("Europe/Moscow"));
        return parseToDateTime(df.format(date));
    }

    public static boolean checkCurrentDay(Date date) {
        DateTime dateTime = new DateTime(date.getTime());
        return dateTime.isBeforeNow();
    }

    public static boolean checkForCurrentDayForBookingTicket(Date date) {
        Date currentDay = new Date();
        return (!checkCurrentDay(date) && (date.getTime() - currentDay.getTime()) / (1000 * 60) >= 10);
    }

    /* ====For password encrypt==== */

    public static String encodePassword(String password) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    /* ====For registration & tickets==== */

    // TODO: FIX
    public static String getHelloContext() throws IOException {
        //File file = ResourceUtils.getFile("classpath:messages/templateForEmailWelcomeMessage.html");
        //return new String(Files.readAllBytes(file.toPath()));
        return null;
    }

    public static String convertDateToString(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }

    public static Date addNMinutes(Date date, Integer n) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        long t = calendar.getTimeInMillis();

        return new Date(t + (n * DistanceManager.ONE_MINUTE_IN_MILLIS));
    }
}
