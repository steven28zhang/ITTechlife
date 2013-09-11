/**
 * 
 */
package com.sxw.itl.domain.geo;

/**
 * @author stephenxianweizhang@gmail.com
 * 
 */
public class Country {

	private String countryCode = null;
	private String countryName = null;
	private String countryCode3Chars = null;

	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * @param countryCode
	 *            the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * @return the countryName
	 */
	public String getCountryName() {
		return countryName;
	}

	/**
	 * @param countryName
	 *            the countryName to set
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	/**
	 * @return the countryCode3Chars
	 */
	public String getCountryCode3Chars() {
		return countryCode3Chars;
	}

	/**
	 * @param countryCode3Chars
	 *            the countryCode3Chars to set
	 */
	public void setCountryCode3Chars(String countryCode3Chars) {
		this.countryCode3Chars = countryCode3Chars;
	}

}
