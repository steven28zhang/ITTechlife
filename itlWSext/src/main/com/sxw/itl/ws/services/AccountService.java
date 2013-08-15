/**
 * 
 */
package com.sxw.itl.ws.services;

import java.util.List;

import com.sxw.itl.ws.entities.Account;

/**
 * @author stephenxianweizhang@gmail.com
 * 
 */
public interface AccountService {

	/**
	 * 
	 * @param account
	 */
	public void insertAccount(Account account);

	/**
	 * 
	 * @param name
	 * @return
	 */
	public List<Account> getAccounts(String name);
}
