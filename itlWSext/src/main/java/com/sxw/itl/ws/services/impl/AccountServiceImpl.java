/**
 * 
 */
package com.sxw.itl.ws.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.sxw.itl.ws.entities.Account;
import com.sxw.itl.ws.services.AccountService;

/**
 * @author stephenxianweizhang@gmail.com
 * 
 */
public class AccountServiceImpl implements AccountService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sxw.itl.ws.services.AccountService#insertAccount(com.sxw.itl.ws.entities
	 * .Account)
	 */
	@Override
	public void insertAccount(Account account) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sxw.itl.ws.services.AccountService#getAccounts(java.lang.String)
	 */
	@Override
	public List<Account> getAccounts(String name) {
		List<Account> accounts = new ArrayList<Account>();
		Account account = new Account();
		account.setName("Stephen");
		accounts.add(account);
		account = new Account();
		account.setName("Zhang");
		accounts.add(account);
		return accounts;
	}

}
