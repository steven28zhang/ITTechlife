/**
 * 
 */
package com.sxw.itl.utils.convert;

import com.sxw.itl.common.ITLConstants.NumberBin;

/**
 * @author Stephen.Zhang@covisint.com
 * 
 */
public final class ConvertUtil {

    /**
     * convert the IP4 to a unique int number<br>
     * 
     * @param ip
     * @return
     */
    public static Integer convertIP4FromStringToInt(final String ip) {
        String[] ipStrArray = ip.split("\\.");

        int ipInt = 0;
        for (int i = 3; i >= 0; i--) {
            int tmpIP = Integer.parseInt(ipStrArray[i]);
            if (i == 0) {
                ipInt = ipInt + NumberBin.bin2power24 + tmpIP;
            } else if (i == 1) {
                ipInt = ipInt + NumberBin.bin2power16 + tmpIP;
            } else if (i == 2) {
                ipInt = ipInt + NumberBin.bin2power8 + tmpIP;
            } else if (i == 3) {
                ipInt = ipInt + tmpIP;
            }
        }
        return ipInt;
    }
}
