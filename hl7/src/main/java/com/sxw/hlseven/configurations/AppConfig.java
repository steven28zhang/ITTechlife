/**
 * 
 */
package com.sxw.hlseven.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * @author Stephen.Zhang@covisint.com
 *
 */
@Configuration
public class AppConfig {

    @Bean
    public ResourceBundleMessageSource messageSource() {  
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();  
        source.setBasename("messages");  
        source.setUseCodeAsDefaultMessage(true);  
        return source;  
    }  
}
