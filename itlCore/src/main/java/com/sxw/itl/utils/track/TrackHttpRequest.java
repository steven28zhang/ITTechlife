/**
 * 
 */
package com.sxw.itl.utils.track;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author stephenxianweizhang@gmail.com
 * 
 */
public class TrackHttpRequest {
	private static final Log logger = LogFactory.getLog(TrackHttpRequest.class);
	private static final String className = TrackHttpRequest.class.getName();

	public static void outputHttpRequest(
			final HttpServletRequest httpServletRequest) {
		String methodName = className + ":outputHttpRequest:";
		StringBuffer sb = new StringBuffer("");
		// remote
		sb.append("remote:").append(httpServletRequest.getRemoteAddr())
				.append(":").append(httpServletRequest.getRemoteHost())
				.append(":").append(httpServletRequest.getRemotePort())
				.append(":").append(httpServletRequest.getRemoteUser());
		sb.append("\n");
		sb.append("Locale:").append(httpServletRequest.getLocale().toString())
				.append(":").append(httpServletRequest.getLocalAddr());
		sb.append("\n");
		try {
			sb.append("body of the request:")
					.append(httpServletRequest.getReader().toString())
					.append(":");
		} catch (IOException e) {
		}
		sb.append("\n");
		sb.append("server:").append(httpServletRequest.getScheme()).append(":")
				.append(httpServletRequest.getServerName()).append(":")
				.append(httpServletRequest.getServletPath()).append(":")
				.append(httpServletRequest.getServletContext()).append(":")
				.append(httpServletRequest.getProtocol());

		sb.append("\n");
		Map<String, String[]> params = httpServletRequest.getParameterMap();
		sb.append(":ParameterMap:");
		for (String key : params.keySet()) {
			sb.append(key).append(":").append(params.get(key).toString()).append(":");
		}

		sb.append("\n");
		Enumeration<String> atts = httpServletRequest.getAttributeNames();
		sb.append(":attributesNames:");
		String attTmp = "";
		while (atts.hasMoreElements()) {
			attTmp = atts.nextElement();
			sb.append(attTmp).append(":")
					.append(httpServletRequest.getAttribute(attTmp))
					.append(":");
		}

		sb.append("\n");
		Cookie[] cookie = httpServletRequest.getCookies();
		sb.append(":Cookie:");
		for (int i = 0; i < cookie.length; i++) {
			sb.append(":").append(cookie[i]).append(":");
		}

		sb.append("\n");
		Enumeration<String> headers = httpServletRequest.getHeaderNames();
		sb.append(":headers:");
		while (headers.hasMoreElements()) {
			attTmp = headers.nextElement();
			sb.append(attTmp).append(":")
					.append(httpServletRequest.getHeader(attTmp)).append(":");
		}

		sb.append("\n");
		sb.append(":OTHERS:").append(httpServletRequest.getAuthType())
				.append(":");
		sb.append("PathInfo:").append(httpServletRequest.getPathInfo())
				.append(":");
		sb.append("QueryString:").append(httpServletRequest.getQueryString())
				.append(":");
		sb.append("UserPrincipal:")
				.append(httpServletRequest.getUserPrincipal()).append(":");
		sb.append("RequestURI:").append(httpServletRequest.getRequestURI())
				.append(":");

		sb.append("\n");
		HttpSession session = httpServletRequest.getSession();
		if (session != null) {
			sb.append(":attributes from session:");

			Enumeration<String> attsSession = session.getAttributeNames();
			sb.append(":attributesNames:");
			while (attsSession.hasMoreElements()) {
				attTmp = attsSession.nextElement();
				sb.append(attTmp).append(":")
						.append(session.getAttribute(attTmp)).append(":");
			}
		}

		sb.append("\n");
		sb.append(":").append(httpServletRequest).append(":");
		logger.debug(methodName + sb.toString());

	}
}
