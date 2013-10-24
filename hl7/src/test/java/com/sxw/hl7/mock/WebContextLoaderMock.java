/**
 * 
 */
package com.sxw.hl7.mock;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.MergedContextConfiguration;
import org.springframework.test.context.support.AbstractContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;

/**
 * @author Stephen.Zhang@covisint.com
 * 
 */
public class WebContextLoaderMock extends AbstractContextLoader {

    private static final ServletContext servletContext = new MockServletContext("/hl7", new FileSystemResourceLoader());

    private static final GenericWebApplicationContext webAppContext = new GenericWebApplicationContext();

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.test.context.SmartContextLoader#loadContext(org.
     * springframework.test.context.MergedContextConfiguration)
     */
    @Override
    public ApplicationContext loadContext(MergedContextConfiguration arg0) throws Exception {
        servletContext.setAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE, webAppContext);
        webAppContext.setServletContext(servletContext);
        new XmlBeanDefinitionReader(webAppContext).loadBeanDefinitions(arg0.getLocations());
        AnnotationConfigUtils.registerAnnotationConfigProcessors(webAppContext);
        webAppContext.refresh();
        webAppContext.registerShutdownHook();
        return webAppContext;
    }

    public static WebApplicationContext getWebAppContextInstance() {
        return webAppContext;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.test.context.ContextLoader#loadContext(java.lang.
     * String[])
     */
    @Override
    public ApplicationContext loadContext(String... arg0) throws Exception {
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.test.context.support.AbstractContextLoader#
     * getResourceSuffix()
     */
    @Override
    protected String getResourceSuffix() {
        return null;
    }

}
