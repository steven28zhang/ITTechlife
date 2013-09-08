/**
 * 
 */
package com.sxw.itl.utils.io.file;

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
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(getFileType("terms and condtions.html"));
	}

}
