/**
 * 
 */
package com.sxw.itl.ws.remote.services;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import com.sxw.itl.ws.entities.Account;

/**
 * @author stephenxianweizhang@gmail.com
 * 
 */
public interface RemoteAccountService extends Remote {

	/**
	 * 
	 * @param account
	 * @throws RemoteException
	 */
	public void insertAccount(Account account) throws RemoteException;

	/**
	 * 
	 * @param name
	 * @return
	 * @throws RemoteException
	 */
	public List<Account> getAccounts(String name) throws RemoteException;
}
