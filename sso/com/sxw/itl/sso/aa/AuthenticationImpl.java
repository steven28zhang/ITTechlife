/**
 * 
 */
package com.sxw.itl.sso.aa;

/**
 * @author stephenxianweizhang@gmail.com
 * 
 */
public class AuthenticationImpl implements Authentication {

	@Override
	public String authenticate(String username, String password,
			String verCode, String type) {
		if ("Stephen".equals(username)) {
			return "Stephen";
		}
		return "NaN";
	}

}
