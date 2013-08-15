/**
 * 
 */
package com.sxw.itl.hw.ws;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author stephenxianweizhang@gmail.com
 * 
 */
public interface Hello extends Remote {

	String sayHello() throws RemoteException;
}
