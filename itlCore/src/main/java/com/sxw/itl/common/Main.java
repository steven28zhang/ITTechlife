/**
 * 
 */
package com.sxw.itl.common;

import java.io.IOException;

import com.sxw.itl.utils.network.URLUtil;
import com.sxw.itl.utils.network.tcp.TCPUtil;
import com.sxw.itl.utils.network.udp.UDPUtil;

/**
 * @author stephenxianweizhang@gmail.com
 * 
 */
public final class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        outPut();
    }

    private static void outPut() {
        System.out.println("ab'cdef".replaceAll("'", "''"));
        String error="text.flight.errorMsg4.fromLocation|text.flight.errorMsg4.toLocation|text.flight.errorMsg4.departDate|text.flight.errorMsg4.departTime|";
        System.out.println(error.substring(0, error.length()-1));
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
