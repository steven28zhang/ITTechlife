/**
 * 
 */
package com.sxw.itl.ws.entities;

import java.io.Serializable;

/**
 * @author stephenxianweizhang@gmail.com
 * 
 */
public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 989445946996868034L;
	private String name;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
