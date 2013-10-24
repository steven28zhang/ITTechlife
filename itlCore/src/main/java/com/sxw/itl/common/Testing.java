/**
 * 
 */
package com.sxw.itl.common;

import java.io.IOException;

import com.sxw.itl.utils.network.URLUtil;
import com.sxw.itl.utils.network.tcp.TCPUtil;
import com.sxw.itl.utils.network.udp.UDPUtil;
import com.sxw.itl.utils.string.StringUtils;

/**
 * @author stephenxianweizhang@gmail.com
 * 
 */
public class Testing {
    private final static String STRING_LENGTH_81="abcdefghijklmnopqrstuvwxyz28abcdefghijklmnopqrstuvwxyz56abcdefghijklmnopqrstuvwxy";
    private final static String STRING_LENGTH_129="abcdefghijklmnopqrstuvwxyz28abcdefghijklmnopqrstuvwxyz56abcdefghijklmnopqrstuvwxyz84abcdefghijklmno|abcdefghijklmnopqrstuvwxyz129";
    private final static String STRING_LENGTH_258=STRING_LENGTH_129+STRING_LENGTH_129;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		doTest();
	}

	static void doTest(){
	    System.out.println(StringUtils.isNotEmptyAndNull(" f "));
//	    System.out.println("abcd".getBytes()[0]);
//	    Object s1 = new String("Hello");
//	    Object s2 = new String("Hello"); 
//	    if(s1 == s2) {
//	      System.out.println("s1 and s2 are ==");
//	    }else if (s1.equals(s2)) {
//	      System.out.println("s1 and s2 are equals()");
//	    }else {
//	     System.out.println("none of above");
//	    }

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
