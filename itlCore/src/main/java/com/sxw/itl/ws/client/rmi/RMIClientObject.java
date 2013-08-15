/**
 * 
 */
package com.sxw.itl.ws.client.rmi;

import java.util.List;

import com.sxw.itl.ws.entities.Account;
import com.sxw.itl.ws.services.AccountService;

/**
 * @author stephenxianweizhang@gmail.com
 * 
 */
public class RMIClientObject {

	private AccountService accountService;

	/**
	 * @param accountService
	 *            the accountService to set
	 */
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	public List<Account> queryAccountsByName(final String name) {
		return accountService.getAccounts("stephen");

	}
}
