/**
 * 
 */
package com.sxw.itl.utils.properties;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

/**
 * @author stephenxianweizhang@gmail.com
 * 
 */
public class QueryProperties {

	private static final Log logger = LogFactory.getLog(QueryProperties.class);
	private static final String className = QueryProperties.class.getName();
	private static Properties props = null;

	/**
	 * 
	 */
	private static void init() {
		if (props == null) {

			Resource resource = new ClassPathResource("/initial.properties");
			try {
				props = PropertiesLoaderUtils.loadProperties(resource);
			} catch (IOException e) {
				logger.info(className, e);
			}

		}
	}

	/**
	 * 
	 * @param key
	 * @return
	 */
	public static final String queryProperty(final String key) {
		init();
		if (props != null) {
			return props.getProperty(key);
		} else {
			return "";
		}
	}

}
