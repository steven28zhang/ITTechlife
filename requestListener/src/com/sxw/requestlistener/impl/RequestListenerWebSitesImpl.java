package com.sxw.requestlistener.impl;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import com.sxw.itl.utils.convert.ConvertUtil;
import com.sxw.requestlistener.constants.RLConstants.RLFeedbackLevel;
import com.sxw.requestlistener.constants.RLConstants.UserAgentTesting;
import com.sxw.requestlistener.entity.RLRequest;

/**
 * 
 * @author Stephen.Zhang@covisint.com
 * 
 */
public final class RequestListenerWebSitesImpl {

    /**
     * 
     * @param servletRequest
     * @return
     */
    public int monitoring(final ServletRequest servletRequest) {
        if (servletRequest == null) {
            return RLFeedbackLevel.NORMAL;
        }
        long currentTime = System.currentTimeMillis();
        RLRequest request = new RLRequest();
        // fetch inputs
        if (servletRequest instanceof HttpServletRequest) {
            HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
            request.setRemoteIP(ConvertUtil.convertIP4FromStringToInt(httpServletRequest.getRemoteHost()));
            request.setUserAgent(httpServletRequest.getHeader("user-agent"));
            request.setRequestURI(httpServletRequest.getRequestURI());
            request.setCurrentTime(currentTime);
        }
        // LOG the request
        RequestHandler.reqTmpList.add(request);
        RequestHandler.requestHistory.put(request.getCurrentTime(), request);

        // search the request
        if (RequestHandler.reqFeedBack.containsKey(request.getRemoteIP())) {
            return RequestHandler.reqFeedBack.get(request.getRemoteIP());
        }

        return RLFeedbackLevel.NORMAL;
    }

    public int monitoringTesting(final RLRequest request) {

        long currentTime = System.currentTimeMillis();
        request.setCurrentTime(currentTime);
        // LOG the request
        RequestHandler.reqTmpList.add(request);
        RequestHandler.requestHistory.put(request.getCurrentTime(), request);

        // search the request
        if (RequestHandler.reqFeedBack.containsKey(request.getRemoteIP())) {
            return RequestHandler.reqFeedBack.get(request.getRemoteIP());
        }

        return RLFeedbackLevel.NORMAL;
    }

    public static void main(String[] args) {

        RequestListenerWebSitesImpl requestListenerWebSitesImpl = new RequestListenerWebSitesImpl();
        String ip = "123.45.55.34";
        for (int i = 1; i < 6; i++) {
            RLRequest request = new RLRequest();
            request.setRemoteIP(ConvertUtil.convertIP4FromStringToInt(ip));
            if (i % 5 == 1) {
                request.setUserAgent(UserAgentTesting.chrome);
                request.setRequestURI("/ito");
            } else if (i % 5 == 2) {
                request.setUserAgent(UserAgentTesting.firefox);
                request.setRequestURI("/ito/login.do");
            } else if (i % 5 == 3) {
                request.setUserAgent(UserAgentTesting.msie);
                request.setRequestURI("/ito/showme.do");
            } else if (i % 5 == 4) {
                request.setUserAgent(UserAgentTesting.safari);
                request.setRequestURI("/ito/stephen");
            } else if (i % 5 == 0) {
                request.setUserAgent(UserAgentTesting.opera);
                request.setRequestURI("/ito/stephenzhang");
            }
            requestListenerWebSitesImpl.monitoringTesting(request);
        }
        RequestScannerServers.startServer();
    }

}
