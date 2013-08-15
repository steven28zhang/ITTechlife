/**
 * 
 */
package com.sxw.itl.utils.db;

import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author stephenxianweizhang@gmail.com
 * 
 */
public class DBResourceRelease {

	private static final Log logger = LogFactory
			.getLog(DBResourceRelease.class);
	private static final String className = DBResourceRelease.class.getName();

	/**
	 * 
	 * @param resultSet
	 */
	public static final void release(final ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (Throwable t) {
				logger.info(className
						+ ".release(ResultSet) Result Set release failed: "
						+ t.getMessage());
			}
		}
	}

	/**
	 * 
	 * @param statement
	 */
	public static final void release(final Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (Throwable t) {
				logger.info(className
						+ ".release(Statement) Statement  release failed: "
						+ t.getMessage());
			}
		}
	}
}
