/**
 * 
 */
package com.sxw.itl.sso.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 * @author stephenxianweizhang@gmail.com
 * 
 */
public class BaseController extends AbstractController {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.mvc.AbstractController#handleRequestInternal
	 * (javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			return super.handleRequest(request, response);
		} catch (Exception e) {
			logger.error("Exception thrown", e);
			// TODO
			return null;
		} catch (Throwable e) {
			logger.error("Unrecoverable Exception thrown", e);
			// TODO
			return null;
		}
	}

}
