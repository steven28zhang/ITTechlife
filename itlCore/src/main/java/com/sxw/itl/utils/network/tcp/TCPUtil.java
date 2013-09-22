/**
 * 
 */
package com.sxw.itl.utils.network.tcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author stephenxianweizhang@gmail.com
 * 
 */
public final class TCPUtil {

	public static final void tcpServer(final int port) throws IOException {
		ServerSocket ss = new ServerSocket(port);
		Socket s = ss.accept();
		InputStream ips = s.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(ips));
		OutputStream ops = s.getOutputStream();
		ops.write("hello,World!".getBytes());
		System.out.println(br.readLine());
		br.close();
		ops.close();
		s.close();
		ss.close();
	}

	public static final void tcpClient(final String ipAdd, final int port)
			throws IOException {
		Socket s = new Socket(InetAddress.getByName(ipAdd), port);
		InputStream ips = s.getInputStream();
		OutputStream ops = s.getOutputStream();
		BufferedReader brKey = new BufferedReader(new InputStreamReader(
				System.in));
		DataOutputStream dos = new DataOutputStream(ops);
		BufferedReader brNet = new BufferedReader(new InputStreamReader(ips));
		while (true) {
			String strWord = brKey.readLine();
			dos.writeBytes(strWord + System.getProperty("line.separator"));
			if ("quit".equalsIgnoreCase(strWord)) {
				break;
			} else {
				System.out.println(brNet.readLine());
			}
		}
		dos.close();
		brNet.close();
		brKey.close();
		s.close();
	}
}
