package com.slandshow.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilsManager {

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
}
