/**
 * 
 */
package com.sxw.itl.utils.validations.string;

/**
 * @author stephenxianweizhang@gmail.com
 * 
 */
public class ValidationString {

    /**
     * 
     * @param str
     * @return
     */
    public static final boolean isNull(final String str) {
        if (str == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 
     * @param str
     * @return
     */
    public static final boolean isEmpty(final String str) {
        if (isNull(str)) {
            return true;
        } else {
            if (str.trim().length() == 0) {
                return true;
            } else {
                return false;
            }
        }
    }

    private static final void testString(final String str) {
        if (str != null && str.length() > 0) {
            String idStr = str.substring(0, str.indexOf("^"));
            System.out.println("idStr:" + idStr);
            if (str.lastIndexOf("^") > str.indexOf("^")) {
                String lastName = str.substring(str.indexOf("^") + 1, str.lastIndexOf("^"));
                System.out.println("lastName:" + lastName);
                String firstName = str.substring(str.lastIndexOf("^") + 1);
                System.out.println("firstName:" + firstName);
            }
        }
    }

    public static void main(String[] args) {
        testString("id123456789014^Zhang6^StephenXianwei16");
    }
}
