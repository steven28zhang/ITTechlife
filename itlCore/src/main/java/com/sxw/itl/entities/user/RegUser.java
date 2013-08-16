/**
 * 
 */
package com.sxw.itl.entities.user;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sxw.itl.db.ConnectionPool;
import com.sxw.itl.utils.db.DBResourceRelease;

/**
 * @author stephenxianweizhang@gmail.com
 * 
 */
public class RegUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8093127396190775590L;
	private final Log logger = LogFactory.getLog(getClass());
	private final String className = getClass().getName();

	private String userName;
	private String password;
	private Integer status;
	private static final String SQL_QUERY_REGUSER_BY_USERNAME = "select user_name,password,status from users where user_name=?";

	/**
	 * 
	 * @param userName
	 * @return
	 * @throws SQLException
	 */
	public static RegUser queryRegUserbyUserName(final String userName)
			throws SQLException {
		RegUser regUser = null;
		Connection connection = ConnectionPool.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			statement = connection
					.prepareStatement(SQL_QUERY_REGUSER_BY_USERNAME);
			statement.setString(1, userName);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				regUser = new RegUser();
				regUser.load(resultSet);
			}

		} finally {
			DBResourceRelease.release(resultSet);
			DBResourceRelease.release(statement);
			ConnectionPool.releaseConnection(connection);
		}
		return regUser;
	}

	/**
	 * 
	 * @param resultSet
	 * @throws SQLException
	 */
	private void load(final ResultSet resultSet) throws SQLException {
		this.userName = resultSet.getString(1);
		this.password = resultSet.getString(2);
		this.status = resultSet.getInt(3);
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

}
