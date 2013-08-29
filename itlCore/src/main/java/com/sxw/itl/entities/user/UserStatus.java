/**
 * 
 */
package com.sxw.itl.entities.user;

/**
 * @author stephenxianweizhang@gmail.com
 * 
 */
public enum UserStatus {
	UNKNOWN(0), // If this value is changed change the default constructor
	ACTIVE(1), INACTIVE(2), LOCKED(3), EXPIRED(4);

	UserStatus(int status) {
		this.status = status;
	}

	public static UserStatus getStatus(int status) {
		for (UserStatus userStatus : values()) {
			if (userStatus.value() == status) {
				return userStatus;
			}
		}
		return UNKNOWN;
	}

	private int status;

	public int value() {
		return status;
	}

}
