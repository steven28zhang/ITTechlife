/**
 * 
 */
package com.sxw.requestlistener;

import javax.servlet.ServletRequest;

import com.sxw.requestlistener.impl.RequestListenerWebSitesImpl;

/**
 * It will monitor the request<br>
 * 
 * @author Stephen.Zhang@covisint.com
 * 
 */
public final class RequestListener {

    /**
     * monitor the request<br>
     * 
     * 
     * @param servletRequest
     * @return
     */
    public static final int listening(final ServletRequest servletRequest) {
        return callImpl(servletRequest);
    }

    private static final int callImpl(final ServletRequest servletRequest) {
        RequestListenerWebSitesImpl RequestListenerImpl = new RequestListenerWebSitesImpl();
        return RequestListenerImpl.monitoring(servletRequest);

    }
}
