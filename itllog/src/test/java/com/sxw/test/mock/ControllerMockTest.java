/**
 * 
 */
package com.sxw.test.mock;

import java.io.IOException;

import javax.servlet.ServletException;

import junit.framework.TestCase;

import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletConfig;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.sxw.test.common.ConstantsTestInterface;

/**
 * @author stephenxianweizhang@gmail.com
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = WebContextLoaderMock.class, locations = { "/rest-servlet-qa.xml" })
public abstract class ControllerMockTest extends TestCase implements ConstantsTestInterface {

    static DispatcherServlet dispatcherServlet;

    public MockHttpServletRequest mockRequest(final String method, final String uri, final String jsonObj) {
        MockHttpServletRequest req = new MockHttpServletRequest(method, uri);
        req.addHeader(HEADERKEY, PRINCIPALVAL);
        req.setContentType(CONTENT_TYPE_JSON);
        req.setContent(jsonObj.getBytes());
        return req;
    }

    protected MockHttpServletResponse mockResponse() {
        return new MockHttpServletResponse();
    }

    public MockHttpServletResponse callRequest(final MockHttpServletRequest curRequest) throws ServletException,
            IOException {

        MockHttpServletResponse curResponse = mockResponse();
        getServletInstance().service(curRequest, curResponse);
        MockHttpServletResponse returnedResponse = curResponse;
        return returnedResponse;
    }

    @SuppressWarnings("serial")
    public static DispatcherServlet getServletInstance() {
        if (null == dispatcherServlet) {
            dispatcherServlet = new DispatcherServlet() {
                protected WebApplicationContext createWebApplicationContext(WebApplicationContext parent) {
                    return WebContextLoaderMock.getWebAppContextInstance();
                }
            };

            try {
                dispatcherServlet.init(new MockServletConfig());
            } catch (ServletException se) {
                System.out.println("ServletException:" + se.getMessage());
            }
        }
        return dispatcherServlet;
    }
}
