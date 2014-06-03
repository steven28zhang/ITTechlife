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
    private final static String dateFormat1 = "dd-MMM-yyyy";
    private final static String dateFormat2 = "dd-MMM-yyyy HH:mm";
    private final static String dateFormat3 = "yyyy-MM-dd";
    private final static String dateFormat4 = "hh:mm";

    public static void main(String[] args) {
        test();

    }

    static void test() {
        prj1();
    }

    static void prj1() {
        try {
            final String date = "25-Apr-2014";
            final String time = "00:00";
            String dt = date + " " + time;
            Date dTmp = new SimpleDateFormat(dateFormat2).parse(dt);
            System.out.println("dt:" + dt + ":date:" + dTmp.toString());
            SimpleDateFormat ft = new SimpleDateFormat(dateFormat3);
            String returnVal = ft.format(dTmp);
            ft = new SimpleDateFormat(dateFormat4);
            returnVal = returnVal + "T" + ft.format(dTmp);
            System.out.println("returnVal:" + returnVal);
        } catch (Exception e) {

        }
    }

    static void tBT() {
        String d1 = "10-Jan-2014 00:00";
        String d2 = "10-Jan-2014 00:30";
        Date date1;
        Date date2;
        try {
            date1 = parseDate("dd-MMM-yyyy HH:mm", d1);
            date2 = parseDate("dd-MMM-yyyy HH:mm", d2);
            String dStr1 = formatDate("yyyy-MM-dd", date1);
            String dStr2 = formatDate("yyyy-MM-dd", date2);
            String dStr3 = formatDate("hh:mm", date2);
            System.out.println("dStr1:" + dStr1 + ":dStr2:" + dStr2 + ":dStr3:" + dStr3);
            if (date1.before(date2)) {
                System.out.println("before");
            } else {
                System.out.println("false");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static void tFormat() {
        String d = "10-Jan-2014 00:00";
        // d = d.toUpperCase();
        Date date;
        try {
            date = new SimpleDateFormat("dd-MMM-yyyy HH:mm").parse(d);
            System.out.println(date);
            d = "10-Jan-2014 23:59";
            date = new SimpleDateFormat("dd-MMM-yyyy HH:mm").parse(d);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    static void t() {
        System.out.println(new Date() + ":|:" + System.currentTimeMillis() + ":|:" + new Date().toString());
        Date d = parseDate("yyyyMMddHHmmss.SSSSZZZZ", "20131022013310.0235-0700");
        Date d1 = parseDate("yyyyMMddHHmmss.SSSSZZZZ", "20131022013310.0235-0200");
        Date d2 = parseDate("yyyyMMddHHmmssZZZZ", "20131022013310-0700");
        Date d3 = parseDate("yyyyMMddHHmmss.SSSS", "20131022013310.0235");
        System.out.println(d.getTime() + ":|:" + d1.getTime() + ":|:" + d2.getTime() + ":|:" + d3.getTime());
    }

    static void testRandom() {
        boolean flag = true;
        int i = 0;
        do {
            i++;
            long curTS = System.currentTimeMillis();
            double randomTmp = Math.random() * 100000;
            Integer intTmp = new Double("" + randomTmp).intValue();
            System.out.println("i:" + i + " curTS:" + curTS + " intTmp:" + intTmp);
            if (randomTmp > 99998) {
                flag = false;
            }

        } while (flag);
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
