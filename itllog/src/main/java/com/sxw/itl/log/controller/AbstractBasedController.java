/**
 * 
 */
package com.sxw.itl.log.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * @author stephenxianweizhang@gmail.com
 * 
 */
@PropertySource("app.properties")
public abstract class AbstractBasedController {

    @Autowired
    public ResourceBundleMessageSource messageSource;

    @Value("${outputtype}")
    public String outputtype;

    @Value("${outputfilepath}")
    public String outputfilepath;

    @Value("${outputfileprefix}")
    public String outputfileprefix;
}
