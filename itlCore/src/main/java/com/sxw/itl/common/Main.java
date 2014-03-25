/**
 * 
 */
package com.sxw.itl.common;

import java.io.IOException;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

import org.apache.log4j.Logger;

import com.sxw.itl.utils.network.URLUtil;
import com.sxw.itl.utils.network.tcp.TCPUtil;
import com.sxw.itl.utils.network.udp.UDPUtil;

/**
 * @author stephenxianweizhang@gmail.com
 * 
 */
public final class Main {

    private static final String CLASSNAME = Main.class.getName();
    private static Logger logger = Logger.getLogger(Main.class);

    /**
     * @param args
     */
    public static void main(String[] args) {
        testString();
    }

    static void testString() {
        String locName = "\"~!@#$%^&*()_+";
        String bkSupportChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 '-()/";
        final StringCharacterIterator iterator = new StringCharacterIterator(locName);
        char character = iterator.current();
        while (character != CharacterIterator.DONE) {
            if (bkSupportChars.indexOf(character) >= 0) {
                System.out.println("character:|" + character+"|");
            }
            character = iterator.next();
        }
        String str = "BE7012    BE              BE7012  Jemappes        N       N       N       Y";
        String[] code = { "abc", "def" };
        if (code != null) {
            System.out.println(code.length + "|||" + code[1]);
        }
        // logger.debug("the length of code:" + code.length);
    }

    static void testLog4j() {
        String METHODNAME = CLASSNAME + ":testLog4j:";
        logger.debug(METHODNAME + "BEGIN:");
    }

    private static void outPut() {
        System.out.println("ab'cdef".replaceAll("'", "''"));
        String error = "text.flight.errorMsg4.fromLocation|text.flight.errorMsg4.toLocation|text.flight.errorMsg4.departDate|text.flight.errorMsg4.departTime|";
        System.out.println(error.substring(0, error.length() - 1));
        System.out.println(new Boolean(""));
        System.out.println(new Boolean("TRUE"));
    }

    private static void tTCPUtil() {
        try {
            TCPUtil.tcpServer(11000);
        } catch (IOException e) {
        }
    }

    private static void tUDPUtil() {
        try {
            UDPUtil.udpReceiver(12000);
        } catch (IOException e) {
        }
    }

    private static void tURLUtil() {
        String r = URLUtil.baiduPlaceSuggestionSearch(null, null, null);
        System.out.println("result:\n" + r);
        r = URLUtil.baiduPlaceSearch(null, null, null);
        System.out.println("result:\n" + r);
    }
}
