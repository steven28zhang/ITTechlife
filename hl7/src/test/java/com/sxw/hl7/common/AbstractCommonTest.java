/**
 * 
 */
package com.sxw.hl7.common;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

import com.sxw.hl7.mock.ControllerMockTest;

/**
 * @author Stephen.Zhang@covisint.com
 * 
 */
public class AbstractCommonTest extends ControllerMockTest implements ConstantsTestInterface {
    public String jsonObj;

    /**
     * 
     */
    public void initialize() {
        Authentication authentication = new PreAuthenticatedAuthenticationToken(PRINCIPALVAL, CREDENTIALVAL);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
