/**
 * 
 */
package com.sxw.itl.sso.aa;

/**
 * @author stephenxianweizhang@gmail.com
 * 
 */
public interface Authentication {

	/**
	 * authenticate an user
	 * 
	 * @param username
	 *            required
	 * @param password
	 *            required
	 * @param verCode
	 *            optional
	 * @param type
	 *            optional
	 * @return
	 */
	String authenticate(final String username, final String password,
			final String verCode, final String type);
}
