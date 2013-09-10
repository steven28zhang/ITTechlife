/**
 * 
 */
package com.sxw.itl.utils.io.file;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sxw.itl.common.ITLConstants.Symbols;

/**
 * @author stephenxianweizhang@gmail.com
 * 
 */
public final class FileOperations {

	private static final Log logger = LogFactory.getLog(FileOperations.class);
	private static final String className = FileOperations.class.getName();

	public static final String getFileType(final String fileName) {
		if (fileName == null || fileName.length() < 1) {
			return null;
		}
		String fileType = null;
		if (fileName.indexOf(Symbols.SYMBOL_COMMA) > 0) {
			fileType = fileName.substring(fileName
					.indexOf(Symbols.SYMBOL_COMMA) + 1);
		}
		return fileType;
	}
	
	/**
	 * read the uploaded file<br>
	 * 
	 * @param uploadedFile
	 * @return
	 * @throws IOException
	 */
	public static final byte[] readUploadFile(File uploadedFile)
			throws IOException {
		FileInputStream fileInput = new FileInputStream(uploadedFile);
		byte[] readFile = new byte[fileInput.available()];
		fileInput.read(readFile);
		fileInput.close();
		return readFile;
	}

	/**
	 * 
	 * @param in
	 * @param formDataLength
	 * @return
	 * @throws IOException
	 */
	public static final byte[] readUploadFileInputStream(final DataInputStream in,
			final int formDataLength) throws IOException {
		byte[] readFile = new byte[formDataLength];
		int byteRead = 0;
		int totalBytesRead = 0;
		// this loop converting the uploaded file into byte code
		while (totalBytesRead < formDataLength) {
			byteRead = in.read(readFile, totalBytesRead, formDataLength);
			totalBytesRead += byteRead;
		}
		return readFile;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(getFileType("terms and condtions.html"));
	}

}
