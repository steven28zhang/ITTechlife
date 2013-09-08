/**
 * 
 */
package com.sxw.itl.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sxw.itl.utils.properties.QueryProperties;

/**
 * @author stephenxianweizhang@gmail.com
 * 
 */
public class ConnectionPool {

	private static final Log logger = LogFactory.getLog(ConnectionPool.class);
	private static final String className = ConnectionPool.class.getName();

	private static DataSource dataSource;
	private static boolean trackConnectionFlag = true;
	private static Map<Integer, Connection> connectionMap = new HashMap<Integer, Connection>();
	private static int connectionMaxValue = 20;
	private static int connectionCounter = 0;

	private static void init() {
		if (dataSource == null) {
			logger.info(className + ":The configuration is wrong!");
			return;
		}
		trackConnectionFlag = Boolean.parseBoolean(QueryProperties
				.queryProperty("trackConnectionFlag"));
		connectionMaxValue = Integer.parseInt(QueryProperties
				.queryProperty("connectionMaxValue"));
		logger.debug(className + ":trackConnectionFlag:" + trackConnectionFlag
				+ ":connectionMaxValue:" + connectionMaxValue);
	}

	/**
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		init();
		Connection connection = null;
		try {
			if (trackConnectionFlag && connectionCounter >= connectionMaxValue) {
				logger.info(className
						+ ":getConnection: It's already reach the max value of connection pool");
				return null;
			}
			connection = dataSource.getConnection();
			if (trackConnectionFlag) {
				if (connection != null) {
					connectionCounter++;
					connectionMap.put(connection.hashCode(), connection);
				}
			}
		} catch (SQLException e) {
			logger.error(className, e);
		}

		return connection;
	}

	/**
	 * 
	 * @param connection
	 */
	public static void releaseConnection(final Connection connection) {

		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				logger.error(className, e);
				return;
			}
			if (trackConnectionFlag) {
				connectionCounter--;
			}
		}
	}

	/**
	 * @param dataSource
	 *            the dataSource to set
	 */
	public static void setDataSource(DataSource dataSource) {
		ConnectionPool.dataSource = dataSource;
	}

}
