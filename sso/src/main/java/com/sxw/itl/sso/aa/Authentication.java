/**
 * 
 */
package com.sxw.itl.sso.aa;

import com.sxw.itl.entities.user.RegUser;

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
	RegUser authenticate(final String userName, final String password,
			final String verCode, final String type);
}
