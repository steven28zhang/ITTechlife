/**
 * 
 */
package com.sxw.itl.utils.string;

import org.apache.commons.lang.StringEscapeUtils;

/**
 * @author stephenxianweizhang@gmail.com
 * 
 */
public class StringUtils {

    public static void main(String[] args) {
        t1();
    }

    private static void t1() {
        String baseURL = "https://prv60.mykds.com/kdsInstance/redirect/MA/automation.ashx?";
        baseURL = baseURL.replace("kdsInstance", "KdsInstanceNonSyncvalue");
        System.out.println("baseURL:" + baseURL);

    }

    /**
     * 
     * @param obj
     * @return
     */
    public static boolean isNotEmptyAndNull(final String obj) {

        if (obj == null || obj.trim().length() < 1) {
            return false;
        }

        return true;
    }

    public static void testStringEscapeUtils() {
        String str = "abcde\\'<>()";
        System.out.println(str);
        str = StringEscapeUtils.escapeSql(str);
        System.out.println(str);
    }

}
