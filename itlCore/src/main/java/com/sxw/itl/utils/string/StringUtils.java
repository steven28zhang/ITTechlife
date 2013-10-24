/**
 * 
 */
package com.sxw.itl.utils.string;

/**
 * @author Stephen.Zhang@covisint.com
 * 
 */
public class StringUtils {

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
}
