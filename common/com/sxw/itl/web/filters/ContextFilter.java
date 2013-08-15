/**
 * 
 */
package com.sxw.itl.web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author stephenxianweizhang@gmail.com
 * 
 */
public class ContextFilter implements Filter {

	private final Log logger = LogFactory.getLog(getClass());
	private final String className = getClass().getName();

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		return;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO DELETE
		// OUTPUT ALL INPUTS
		toDelete(arg0);
		arg2.doFilter(arg0, arg1);
	}

	private void toDelete(ServletRequest arg0) {
		logger.debug(className + ":toDelete:");
		if (arg0 != null) {
			HttpServletRequest req = (HttpServletRequest) arg0;
			logger.debug(":" + req.getAuthType());
			logger.debug(":" + req.getCharacterEncoding());
			logger.debug(":" + req.getContentType());
			logger.debug("/itl:" + req.getContextPath());
			logger.debug("127.0.0.1:" + req.getLocalAddr());
			logger.debug("SHA123199N01.clients.apac.cpwr.corp:"
					+ req.getLocalName());
			logger.debug("9090:" + req.getLocalPort());
			logger.debug(":" + req.getLocale().getDisplayName());
			logger.debug(":" + req.getPathInfo());
			logger.debug(":" + req.getPathTranslated());
			logger.debug(":" + req.getProtocol());
			logger.debug(":" + req.getQueryString());
			logger.debug("127.0.0.1:" + req.getRemoteAddr());
			logger.debug(":" + req.getRemotePort());
			logger.debug(":" + req.getRemoteUser());
			logger.debug(":" + req.getRequestedSessionId());
			logger.debug("/itl/login.do:" + req.getRequestURI());
			logger.debug("http://localhost:9090/itl/login.do:"
					+ req.getRequestURL());
			logger.debug("http:" + req.getScheme());
			logger.debug("localhost:" + req.getServerName());
			logger.debug("9090:" + req.getServerPort());
			logger.debug("/login.do:" + req.getServletPath());
			logger.debug(":" + req.getServletContext());
			logger.debug(":" + req.getSession());
			logger.debug(":" + req.getUserPrincipal());
			logger.debug("/itl:" + req.getServletContext().getContextPath());
			logger.debug(":" + req.getParameterMap().keySet().toArray());
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		return;

	}

}
