/**
 * 
 */
package com.sxw.itl.utils.security.encryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;

/**
 * @author Stephen.Zhang@Compuware.com
 * 
 */
public final class MDFiveEncryption {

    private static Logger logger = Logger.getLogger(MDFiveEncryption.class);

    public static final String encodeByMD5(final String value) {
        final String methodName = MDFiveEncryption.class.getName() + ":encodeByMD5:";
        StringBuffer sb = new StringBuffer();
        try {
            MessageDigest mg = MessageDigest.getInstance("MD5");
            mg.update(value.getBytes());
            byte[] mdbytes = mg.digest();

            for (int i = 0; i < mdbytes.length; i++) {
                sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            logger.debug(methodName + "value:" + value + ":|" + sb.toString() + "|");
        } catch (NoSuchAlgorithmException e) {

        }

        return sb.toString();
    }
}
