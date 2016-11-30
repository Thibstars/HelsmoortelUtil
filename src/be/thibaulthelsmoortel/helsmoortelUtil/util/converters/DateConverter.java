/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

package be.thibaulthelsmoortel.helsmoortelUtil.util.converters;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Thibault Helsmoortel
 */

/**
 * Class for converting dates to strings and vice versa.
 */
public class DateConverter {
    private static final String DEFAULT_STRING_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final SimpleDateFormat DEFAULT_FORMAT = new SimpleDateFormat(DEFAULT_STRING_FORMAT);

    /**
     * Converts a date to a string.
     * @param date the date to convert
     * @return the converted date as a string
     */
    public static String dateToString(Date date) {
        return dateToString(date, DEFAULT_FORMAT);
    }

    /**
     * Converts a date to a string based on a date format.
     * @param date the date to convert
     * @param dateFormat the date format as a string
     * @return the converted date as a string
     */
    public static String dateToString(Date date, String dateFormat) {
        DateFormat df = new SimpleDateFormat(dateFormat);
        return df.format(date);
    }

    /**
     * Converts a date to a string based on a date format.
     * @param date the date to convert
     * @param dateFormat the date format as a SimpleDateFormat
     * @return the converted date as a string
     */
    public static String dateToString(Date date, SimpleDateFormat dateFormat) {
        DateFormat df;
        if (dateFormat == null) df = DEFAULT_FORMAT;
        else df = dateFormat;
        return df.format(date);
    }

    /**
     * Converts a string to a date.
     * @param string the string to convert
     * @return the converted string as a date.
     */
    public static Date stringToDate(String string) {
        return stringToDate(string, DEFAULT_FORMAT);
    }

    /**
     * Converts a string to a date based on a date format.
     * @param string the string to convert
     * @param dateFormat the date format as a string
     * @return the converted string as a date
     */
    public static Date stringToDate(String string, String dateFormat) {
        if (dateFormat == null) dateFormat = DEFAULT_STRING_FORMAT;
        DateFormat format = new SimpleDateFormat(dateFormat);
        Date date = null;
        try {
            date = format.parse(string);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * Converts a string to a date based on a date format.
     * @param string the string to convert
     * @param dateFormat the date format as a SimpleDateFormat
     * @return the converted string as a date
     */
    public static Date stringToDate(String string, SimpleDateFormat dateFormat) {
        if (dateFormat == null) dateFormat = DEFAULT_FORMAT;
        DateFormat format = dateFormat;
        Date date = null;
        try {
            date = format.parse(string);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }
}
