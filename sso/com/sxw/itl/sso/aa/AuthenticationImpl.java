/**
 * 
 */
package com.sxw.itl.sso.aa;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sxw.itl.entities.user.RegUser;
import com.sxw.itl.entities.user.UserStatus;
import com.sxw.itl.ws.client.rmi.RMIClientObject;
import com.sxw.itl.ws.entities.Account;

/**
 * @author stephenxianweizhang@gmail.com
 * 
 */
public class AuthenticationImpl implements Authentication {

	private final Log logger = LogFactory.getLog(getClass());
	private final String className = getClass().getName();

	@Override
	public RegUser authenticate(String userName, String password,
			String verCode, String type) {
		final String methodName = className + ":authenticate:";
		RegUser r = null;

		// TODO delete the service testing
		doServiceTesting();
		// Step1: query the user
		try {
			r = RegUser.queryRegUserbyUserName(userName);
		} catch (SQLException e) {
		}
		if (r != null) {
			logger.debug(methodName + "userName:" + r.getUserName());
			// Step2: validate the password
			if (password.trim().equals(r.getPassword())) {
				// Step3: validate the status
				if (r.getStatus() == UserStatus.ACTIVE) {
					return r;
				}
			}

		}
		return null;
	}

	private void doServiceTesting() {
		final String methodName = className + ":doServiceTesting:";
		logger.debug(methodName + "BEGIN:");

		List<Account> accounts = rmiClientObject.queryAccountsByName("");
		if (accounts != null) {
			for (Account account : accounts) {
				logger.debug(methodName + "name:" + account.getName());
			}
		}

		logger.debug(methodName + ":END");

	}

	/**
	 * delete the following
	 */

	RMIClientObject rmiClientObject;

	/**
	 * @param rmiClientObject
	 *            the rmiClientObject to set
	 */
	public void setRmiClientObject(RMIClientObject rmiClientObject) {
		this.rmiClientObject = rmiClientObject;
	}
}
