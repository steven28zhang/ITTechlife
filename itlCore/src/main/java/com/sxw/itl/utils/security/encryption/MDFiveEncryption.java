/**
 * 
 */
package com.sxw.itl.utils.security.encryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;

import com.sxw.itl.common.ITLConstants;

/**
 * @author Stephen.Zhang@Compuware.com
 * 
 */
public final class MDFiveEncryption {

	private static Logger logger = Logger.getLogger(MDFiveEncryption.class);
	private static final String className = MDFiveEncryption.class.getName();

	/**
	 * 
	 * @param value
	 * @return
	 */
	public static final String encodeByMD5(final String value) {
		final String methodName = className + ":encodeByMD5:";
		StringBuffer sb = new StringBuffer();
		try {
			MessageDigest mg = MessageDigest
					.getInstance(ITLConstants.MD5Transformation);
			mg.update(value.getBytes());
			byte[] mdbytes = mg.digest();

			for (int i = 0; i < mdbytes.length; i++) {
				sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16)
						.substring(1));
			}
			logger.debug(methodName + "value:" + value + ":|" + sb.toString()
					+ "|");
		} catch (NoSuchAlgorithmException e) {
			logger.info(methodName, e);
		}

		return sb.toString();
	}

	/**
	 * 
	 * @param value
	 * @return
	 */
	public static final byte[] getMD5Digest(final String value) {
		final String methodName = className + ":getMD5Digest:";
		try {
			MessageDigest mg = MessageDigest
					.getInstance(ITLConstants.MD5Transformation);
			mg.update(value.getBytes());
			byte[] mdbytes = mg.digest();
			return mdbytes;
		} catch (NoSuchAlgorithmException e) {
			logger.info(methodName, e);
		}

		return null;
	}

}
