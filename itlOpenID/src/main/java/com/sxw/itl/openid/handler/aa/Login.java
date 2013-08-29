/**
 * 
 */
package com.sxw.itl.openid.handler.aa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sxw.itl.entities.user.RegUser;
import com.sxw.itl.openid.handler.BasedHanlders;

/**
 * handle the login part.
 * 
 * @author stephenxianweizhang@gmail.com
 * 
 */
@Controller
public class Login extends BasedHanlders {

	private final Log logger = LogFactory.getLog(getClass());
	private final String className = getClass().getName();

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model uiModel, HttpServletResponse httpServletResponse) {

		httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginAA(@Valid RegUser regUser, Model uiModel,
			BindingResult bindingResult,
			HttpServletResponse httpServletResponse,
			HttpServletRequest httpServletRequest) {

		if (bindingResult.hasErrors()) {
			uiModel.addAttribute(regUser);
			return "login";
		}
		final String methodName = className + ":loginAA:";
		logger.debug(methodName + "userName:" + regUser.getUserName()
				+ ":password:" + regUser.getPassword());

		return "public/aboutMe";
	}
}
