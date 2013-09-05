/**
 * 
 */
package com.sxw.itl.exe;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author stephenxianweizhang@gmail.com
 * 
 */
public class FileOperations {

	public static final String SPLIT_SIGN = "|";
	protected static String usrDir = System.getProperty("user.dir");
	protected static String fsep = System.getProperty("file.separator");

	/**
	 * step 1: read the file line by line;<br>
	 * step 2: reverse the order;<br>
	 * 
	 * @param fileName
	 */
	public void reverseOrderOfFileContent(final String fileName) {
		BufferedReader br = null;
		long curTime = System.currentTimeMillis();
		try {
			br = new BufferedReader(new FileReader(fileName));
			String line;
			while ((line = br.readLine()) != null) {
				// System.out.println("line:" + line);
				reveralString(line, SPLIT_SIGN);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				br = null;
			}
		}
		long difference = System.currentTimeMillis() - curTime;
		System.out.print("It takes " + difference + " Millis");
	}

	/**
	 * 
	 * @param content
	 * @param splitSign
	 * @return
	 */
	public String reveralString(final String content, final String splitSign) {
		if (content == null || content.trim().length() < 1) {
			return null;
		}
		String[] tmp = content.split(splitSign);
		StringBuffer rs = new StringBuffer("");
		for (int i = tmp.length - 1; i >= 0; i--) {
			if (splitSign.equals(tmp[i])) {
				continue;
			}
			rs.append(tmp[i]);
		}
		System.out.println("result:" + rs.toString());

		return rs.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringBuffer filePath = new StringBuffer(usrDir);
		String outputPath = "bin";
		filePath.append(fsep).append(outputPath).append(fsep);
		String fileName = filePath + "convert.txt";
		System.out.println("fileName:" + fileName);
		FileOperations fo = new FileOperations();
		fo.reverseOrderOfFileContent(fileName);

	}

}
