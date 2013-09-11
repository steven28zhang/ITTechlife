/**
 * 
 */
package com.sxw.itl.convert.apache;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sxw.itl.common.ITLConstants.Encoding;

/**
 * @author stephenxianweizhang@gmail.com
 * 
 */
public final class ApacheIOUtils {

	private static final Log logger = LogFactory.getLog(ApacheIOUtils.class);
	private static final String className = ApacheIOUtils.class.getName();

	public static String convertInputStreamToString(
			final InputStream inputStream) {
		final String methodName = className + ":convertInputStreamToString:";
		StringWriter writer = new StringWriter();
		try {
			IOUtils.copy(inputStream, writer, Encoding.UTF8STR);
		} catch (IOException e) {
			logger.info(methodName, e);
		}
		String result = writer.toString();

		return result;
	}
}
