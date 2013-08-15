/**
 * 
 */
package com.sxw.itl.utils.security.encryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Stephen
 * 
 */
public class MDFiveJava {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args != null && args.length > 0) {
			for (String arg : args) {
				StringBuffer sb = new StringBuffer();
				try {
					MessageDigest mg = MessageDigest.getInstance("MD5");
					mg.update(arg.getBytes());
					byte[] mdbytes = mg.digest();

					for (int i = 0; i < mdbytes.length; i++) {
						sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100,
								16).substring(1));
					}
					System.out.println("arg:" + arg + ":|" + sb.toString()
							+ "|");
				} catch (NoSuchAlgorithmException e) {

				}
			}
		}

	}

}
