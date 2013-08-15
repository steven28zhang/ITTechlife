/**
 * 
 */
package com.sxw.itl.utils.validations.string;

/**
 * @author stephenxianweizhang@gmail.com
 * 
 */
public class ValidationString {

	/**
	 * 
	 * @param str
	 * @return
	 */
	public static final boolean isNull(String str) {
		if (str == null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @param str
	 * @return
	 */
	public static final boolean isEmpty(String str) {
		if (isNull(str)) {
			return true;
		} else {
			if (str.trim().length() == 0) {
				return true;
			} else {
				return false;
			}
		}
	}
}
