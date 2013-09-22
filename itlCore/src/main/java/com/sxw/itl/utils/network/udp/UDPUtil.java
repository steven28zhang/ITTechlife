/**
 * 
 */
package com.sxw.itl.utils.network.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author stephenxianweizhang@gmail.com
 * 
 */
public final class UDPUtil {

	public static final Object udpReceiver(final int port) throws IOException {
		DatagramSocket ds = new DatagramSocket(port);
		byte[] buf = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf, buf.length);
		ds.receive(dp);
		String str = new String(dp.getData(), 0, dp.getLength());
		System.out.println(str);
		System.out.println("IP:" + dp.getAddress().getHostAddress() + ",PORT:"
				+ dp.getPort());
		ds.close();
		return null;
	}

	public static final void udpSender(final byte[] content,
			final String ipAdd, final int port) throws IOException {
		DatagramSocket ds = new DatagramSocket();
		DatagramPacket dp = new DatagramPacket(content, content.length,
				InetAddress.getByName(ipAdd), port);
		ds.send(dp);
		ds.close();
	}
}
