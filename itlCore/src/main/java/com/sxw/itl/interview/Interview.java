/**
 * 
 */
package com.sxw.itl.interview;

/**
 * @author stephenxianweizhang@gmail.com
 * 
 */
public final class Interview {

    /**
     * 
     * @author stephenxianweizhang@gmail.com
     * 
     */
    public interface ConvertIPFromStringToLong {
        Integer convertIPFromStringToLong(final String ipAdd);
    }

    public interface M2N {
        String convertM2N(final String mValue, final int m, final int n);
    }
}
