/**
 * 
 */
package com.sxw.itl.utils.security.encryption;

import com.sun.org.apache.xml.internal.security.utils.Base64;

/**
 * @author Stephen
 * 
 */
public class MDFiveJava {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str1 = "sztechlife";
		String str2 = "stephenxianweizhangtechlifestephenxianweizhangtechlifestephenxianweizhangtechlife";
		String v1 = new String(Base64.encode(MDFiveEncryption.getMD5Digest(str1)));
		String v2 = new String(Base64.encode(MDFiveEncryption.getMD5Digest(str2)));
		System.out.println(str1 + " :||:" + v1);
		System.out.println(str2 + " :||:" + v2);
	}
}
