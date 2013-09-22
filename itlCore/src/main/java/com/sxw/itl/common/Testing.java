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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		tTCPUtil();
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
