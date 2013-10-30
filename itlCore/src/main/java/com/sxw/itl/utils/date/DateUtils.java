/**
 * 
 */
package com.sxw.itl.utils.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author stephenxianweizhang@gmail.com
 * 
 */
public final class DateUtils {

    public static void main(String[] args) {
        System.out.println(new Date() + ":|:" + System.currentTimeMillis()+":|:"+new Date().toString());
        Date d=parseDate("yyyyMMddHHmmss.SSSSZZZZ","20131022013310.0235-0700");
        Date d2=parseDate("yyyyMMddHHmmssZZZZ","20131022013310-0700");
        Date d3=parseDate("yyyyMMddHHmmss.SSSS","20131022013310.0235");
        System.out.println(d+":|:"+d.getTime()+":|:"+d2.getTime()+":|:"+d3.getTime());
    }

    /**
     * 
     * @param formatStyle
     *            required
     * @param date
     *            optional, if null will return the current time
     * @return
     */
    public static final String formatDate(final String formatStyle, Date date) {

        if (date == null) {
            date = new Date();
        }
        SimpleDateFormat ft = new SimpleDateFormat(formatStyle);
        return ft.format(date);
    }

    /**
     * 
     * @param formatStyle
     *            required
     * @param date
     * @return
     */
    public static final Date parseDate(final String formatStyle, String date) {

        if (date == null) {
            date = new Date().toString();
        }
        SimpleDateFormat ft = new SimpleDateFormat(formatStyle);
        try {
            return ft.parse(date);
        } catch (ParseException e) {

        }
        return null;
    }

    /**
     * 
     * @param startTime
     *            required
     * @param endTime
     *            optional,if it's null, will return current time
     * @return
     */
    public static final Long elapseTime(final Long startTime, Long endTime) {

        if (endTime == null) {
            endTime = System.currentTimeMillis();
        }

        return endTime - startTime;
    }
}
