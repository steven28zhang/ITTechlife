/**
 * 
 */
package com.sxw.requestlistener.util;

/**
 * @author Stephen.Zhang@covisint.com
 * 
 */
public final class MonitorRulesUtil {

    /**
     * it supports normal browsers:<br>
     * 1. chrome<br>
     * 2. firefox <br>
     * 3. IE <br>
     * 4. Safari<br>
     * 5. Opera <br>
     * 
     * @param userAgent
     * @return
     */
    public static boolean isRequestUserAgentNormal(final String userAgent) {
        if (userAgent.indexOf("MSIE") > 0) {
            return true;
        } else if (userAgent.indexOf("Firefox") > 0) {
            return true;
        } else if (userAgent.indexOf("Chrome") > 0) {
            return true;
        } else if (userAgent.indexOf("Safari") > 0) {
            return true;
        } else if (userAgent.indexOf("Opera") > 0) {
            return true;
        }
        return false;
    }
}
