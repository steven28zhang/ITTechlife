/**
 * 
 */
package com.sxw.itl.openid.handler.aa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sxw.itl.openid.handler.BasedHanlders;

/**
 * handle the login part.
 * 
 * @author stephenxianweizhang@gmail.com
 * 
 */
@Controller
public class Login extends BasedHanlders {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model uiModel, HttpServletResponse httpServletResponse) {

		httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginAA(Model uiModel, BindingResult bindingResult, HttpServletResponse httpServletResponse, HttpServletRequest httpServletRequest) {
		
		return "public/aboutMe";
	}
}
