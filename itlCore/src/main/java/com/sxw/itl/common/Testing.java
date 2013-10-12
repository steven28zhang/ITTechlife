/**
 * 
 */
package com.sxw.itl.common;

import java.io.IOException;

import com.sxw.itl.utils.network.tcp.TCPUtil;
import com.sxw.itl.utils.network.udp.UDPUtil;

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
		System.out.println(STRING_LENGTH_81.length());
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
