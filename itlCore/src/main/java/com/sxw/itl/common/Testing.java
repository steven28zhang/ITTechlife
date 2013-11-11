/**
 * 
 */
package com.sxw.itl.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.sxw.itl.utils.network.tcp.TCPUtil;
import com.sxw.itl.utils.network.udp.UDPUtil;
import com.sxw.itl.utils.string.StringUtils;

/**
 * @author stephenxianweizhang@gmail.com
 * 
 */
public class Testing {
    private final static String STRING_LENGTH_81 = "abcdefghijklmnopqrstuvwxyz28abcdefghijklmnopqrstuvwxyz56abcdefghijklmnopqrstuvwxy";
    private final static String STRING_LENGTH_129 = "abcdefghijklmnopqrstuvwxyz28abcdefghijklmnopqrstuvwxyz56abcdefghijklmnopqrstuvwxyz84abcdefghijklmno|abcdefghijklmnopqrstuvwxyz129";
    private final static String STRING_LENGTH_258 = STRING_LENGTH_129 + STRING_LENGTH_129;

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("");
        doTest();
    }

    static void doTest() {
        System.out.println(StringUtils.isNotEmptyAndNull(" f "));
        System.out.println("calcuate: "+(1<<30));
        //tMapIP();
        // System.out.println("abcd".getBytes()[0]);
        // Object s1 = new String("Hello");
        // Object s2 = new String("Hello");
        // if(s1 == s2) {
        // System.out.println("s1 and s2 are ==");
        // }else if (s1.equals(s2)) {
        // System.out.println("s1 and s2 are equals()");
        // }else {
        // System.out.println("none of above");
        // }

    }

    private static void tMapIP() {
        String ip1 = "127.0.0.1";
        String ip2 = "127.0.0.1";
        String ip3 = "123.45.55.34";
        Object obj = new Object();
        Map<Integer, Object> ipMaps = new HashMap<Integer, Object>();
        ipMaps.put(convertIPFromStringToInt(ip1), obj);
        ipMaps.put(convertIPFromStringToInt(ip2), obj);
        ipMaps.put(convertIPFromStringToInt(ip3), obj);
        Integer ipIntArr1 = convertIPFromStringToInt(ip3);
        System.out.println("ipIntArr1::" + ipIntArr1);
        Integer ipIntArr2 = convertIPFromStringToInt("255.255.255.255");
        System.out.println("ipIntArr2::" + ipIntArr2);
        for (Integer key : ipMaps.keySet()) {
            System.out.println("tMapIP:key:" + key);
        }
        System.out.println("tMapIP:" + ipMaps.containsKey(ipIntArr1));
        System.out.println("tMapIP:" + ipMaps.containsKey(ipIntArr2));

    }

    private static Integer convertIPFromStringToInt(final String ip) {
        String[] ipStrArray = ip.split("\\.");
        System.out.println("convertIPFromStringToInt:ip:" + ip);
        int consInt24 = 16777216;
        int consInt16 = 65536;
        int consInt8 = 256;
        int ipInt = 0;
        for (int i = 3; i >= 0; i--) {
            int tmp = Integer.parseInt(ipStrArray[i]);
            System.out.println("convertIPFromStringToInt:tmp:" + tmp);
            if (i == 0) {
                ipInt = ipInt + consInt24 + tmp;
                System.out.println("convertIPFromStringToInt:ipInt:" + ipInt);
            } else if (i == 1) {
                ipInt = ipInt + consInt16 + tmp;
                System.out.println("convertIPFromStringToInt:ipInt:" + ipInt);
            } else if (i == 2) {
                ipInt = ipInt + consInt8 + tmp;
                System.out.println("convertIPFromStringToInt:ipInt:" + ipInt);
            } else if (i == 3) {
                ipInt = ipInt + tmp;
                System.out.println("convertIPFromStringToInt:ipInt:" + ipInt);
            }
        }
        System.out.println("convertIPFromStringToInt:ip:" + ip);
        System.out.println("convertIPFromStringToInt:ip:====================");
        return ipInt;
    }

    private static void tTCPUtil() {
        try {
            TCPUtil.tcpClient("192.168.11.3", 11000);
        } catch (IOException e) {
        }
    }

    private static void tUDPUtil() {
        try {
            UDPUtil.udpSender("Hello Stephen!".getBytes(), "127.0.0.1", 12000);
        } catch (IOException e) {
        }
    }

}
