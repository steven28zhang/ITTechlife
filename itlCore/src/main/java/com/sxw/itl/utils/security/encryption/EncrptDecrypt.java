/**
 * 
 */
package com.sxw.itl.utils.security.encryption;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sxw.itl.common.Base64Coder;
import com.sxw.itl.common.ITLConstants;
import com.sxw.itl.common.ITLConstants.EncrptionMode;

/**
 * @author stephenxianweizhang@gmail.com
 * 
 */
public class EncrptDecrypt {

	private static final Log logger = LogFactory.getLog(EncrptDecrypt.class);
	private static final String className = EncrptDecrypt.class.getName();
	private SecretKey secretKey = null;
	private int length = ITLConstants.securityDefaultLength;

	private static EncrptDecrypt encrptDecrypt = new EncrptDecrypt();

	private EncrptDecrypt() {
		secretKey = createKey(ITLConstants.securityEncryptionSeed);
	}

	private SecretKey createKey(String seed) {
		SecretKey key = null;
		key = new SecretKeySpec(createSeed(seed).getBytes(),
				ITLConstants.securityDefaultTransformation);

		return key;
	}

	private String createSeed(String str) {
		int keySize = length / 8;
		StringBuffer sb = new StringBuffer(new String(Base64Coder.encode(str
				.getBytes()))).reverse();

		String seed = sb.toString().substring(sb.length() / 2);
		seed += new String(Base64Coder.encode(MDFiveEncryption.getMD5Digest(sb
				.toString())));

		if (seed.length() > keySize) {
			seed = seed.substring(0, keySize);
		} else {
			seed += "stephen8XianWeiZhang22on2013EnjoyThe38TechLifeFavoritesis59WalkingSurfing75Network84CPWRCVICSE95"
					.substring(0, keySize - seed.length());
		}
		System.out.println("keySize:" + keySize + ":seed:" + seed);
		return seed;
	}

	private byte[] doCipher(byte[] data, String mode)
			throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		final String methodName = className + ":doCipher:";
		byte[] returnValue = null;
		Cipher cipher = null;

		if (data == null || mode == null) {
			logger.info(methodName + " the input parameters are null!");
			return null;
		}

		cipher = Cipher.getInstance(ITLConstants.securityDefaultTransformation);
		if (mode.equalsIgnoreCase(EncrptionMode.ENCRYPT_MODE)) {
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			byte[] encrypted = cipher.doFinal(data);
			returnValue = encrypted;
		} else if (mode.equalsIgnoreCase(EncrptionMode.DECRYPT_MODE)) {
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			byte[] decrypted = cipher.doFinal(data);
			returnValue = decrypted;
		}

		return returnValue;
	}

	/**
	 * 
	 * @param toEncrypt
	 * @return
	 */
	public static String encryptString(String toEncrypt) {

		try {
			byte[] enCode = encrptDecrypt.doCipher(toEncrypt.getBytes(),
					EncrptionMode.ENCRYPT_MODE);
			return new String(Base64Coder.encode(enCode));
		} catch (InvalidKeyException e) {
		} catch (NoSuchAlgorithmException e) {
		} catch (NoSuchPaddingException e) {
		} catch (IllegalBlockSizeException e) {
		} catch (BadPaddingException e) {
		}

		return "";
	}

	/**
	 * 
	 * @param toDecrypt
	 * @return
	 */
	public static String decryptString(String toDecrypt) {

		try {
			byte[] enCode = encrptDecrypt.doCipher(Base64Coder.decode(toDecrypt),
					EncrptionMode.DECRYPT_MODE);
			return new String(enCode,"UTF-8");
		} catch (InvalidKeyException e) {
		} catch (NoSuchAlgorithmException e) {
		} catch (NoSuchPaddingException e) {
		} catch (IllegalBlockSizeException e) {
		} catch (BadPaddingException e) {
		} catch (UnsupportedEncodingException e) {
		} 

		return "";
	}

	public static void main(String[] args) {
		System.out.println();
		String str = "hello";
		String r = encryptString(str);
		String rr = decryptString(r);
		System.out.println("str:" + str);
		System.out.println("result:" + r);
		System.out.println("result:" + rr);

	}
}
