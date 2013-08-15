/**
 * 
 */
package com.sxw.itl.sso.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;

import com.sxw.itl.common.ITLConstants.Pages;
import com.sxw.itl.entities.user.RegUser;
import com.sxw.itl.sso.aa.Authentication;
import com.sxw.itl.sso.web.BaseController;
import com.sxw.itl.utils.validations.string.ValidationString;

/**
 * @author stephenxianweizhang@gmail.com
 * 
 */
public class Login extends BaseController {

	private final Log logger = LogFactory.getLog(getClass());
	private final String className = getClass().getName();

	private Authentication authenticate = null;

	/**
	 * 
	 */
	public ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		final String methodName = className + ":handleRequestInternal:";
		String userName = request.getParameter("UserName");
		String password = request.getParameter("Passwd");
		logger.debug(methodName + ":userName:" + userName + ":password:"
				+ password);
		if (ValidationString.isEmpty(userName)
				|| ValidationString.isEmpty(password)) {
			return forwardLoginView(request, response);
		} else {
			RegUser r = authenticate.authenticate(userName, password, null,
					null);
			if (r != null) {
				logger.debug(methodName + ":RegUser:status:" + r.getStatus());
				return new ModelAndView(Pages.PUBLIC_ABOUTME);
			} else {
				return forwardLoginView(request, response);
			}
		}
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView forwardLoginView(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return new ModelAndView(Pages.SSO_LOGIN_PAGE);
	}

	/**
	 * @param authenticate
	 *            the authenticate to set
	 */
	public void setAuthenticate(Authentication authenticate) {
		this.authenticate = authenticate;
	}
}
