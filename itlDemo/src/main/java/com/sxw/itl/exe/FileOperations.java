/**
 * 
 */
package com.sxw.itl.exe;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * TODO add the log4j and remove system.out<br>
 * 
 * @author stephenxianweizhang@gmail.com
 * 
 */
public class FileOperations {

	/**
	 * step 1: read the file line by line;<br>
	 * step 2: reverse the order;<br>
	 * 
	 * @param fileName
	 * @throws IOException
	 */
	public void reverseOrderOfFileContent(final String fileName,
			final String splitSign) throws IOException {
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(fileName));
			String line;
			while ((line = br.readLine()) != null) {
				// System.out.println("line:" + line);
				reverseOrderString(line, splitSign);
			}
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException();
		} catch (IOException e) {
			throw new IOException();
		} finally {
			if (br != null) {
				br = null;
			}
		}

	}

	/**
	 * 
	 * @param content
	 * @param splitSign
	 * @return
	 */
	public String reverseOrderString(final String content,
			final String splitSign) {
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
		// System.out.println("result:" + rs.toString());
		System.out.println(rs.toString());

		return rs.toString();
	}

}
