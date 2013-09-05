/**
 * 
 */
package com.sxw.itl;

import com.sxw.itl.exe.FileOperations;

/**
 * @author stephenxianweizhang@gmail.com
 * 
 */
public class Main {

	public static final String SPLIT_SIGN = "|";
	protected static String usrDir = System.getProperty("user.dir");
	protected static String fsep = System.getProperty("file.separator");

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Testing 1: Character Reversal Problem
		StringBuffer filePath = new StringBuffer(usrDir);
		String outputPath = "bin";
		filePath.append(fsep).append(outputPath).append(fsep);
		String fileName = filePath + "convert.txt";
		// System.out.println("fileName:" + fileName);
		FileOperations fo = new FileOperations();
		long curTime = System.currentTimeMillis();
		try {
			fo.reverseOrderOfFileContent(fileName, SPLIT_SIGN);
		} catch (Exception e) {
		}
		long difference = System.currentTimeMillis() - curTime;
		System.out.print("It takes " + difference + " Millis");

	}

}
