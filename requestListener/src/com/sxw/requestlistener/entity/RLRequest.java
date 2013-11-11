/**
 * 
 */
package com.sxw.requestlistener.entity;

/**
 * @author Stephen.Zhang@covisint.com
 * 
 */
public class RLRequest {

    private Integer remoteIP;
    private String userAgent;
    private String requestURI;
    private Long currentTime;

    /**
     * @return the remoteIP
     */
    public Integer getRemoteIP() {
        return remoteIP;
    }

    /**
     * @param remoteIP
     *            the remoteIP to set
     */
    public void setRemoteIP(Integer remoteIP) {
        this.remoteIP = remoteIP;
    }

    /**
     * @return the userAgent
     */
    public String getUserAgent() {
        return userAgent;
    }

    /**
     * @param userAgent
     *            the userAgent to set
     */
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    /**
     * @return the requestURI
     */
    public String getRequestURI() {
        return requestURI;
    }

    /**
     * @param requestURI
     *            the requestURI to set
     */
    public void setRequestURI(String requestURI) {
        this.requestURI = requestURI;
    }

    /**
     * @return the currentTime
     */
    public Long getCurrentTime() {
        return currentTime;
    }

    /**
     * @param currentTime the currentTime to set
     */
    public void setCurrentTime(Long currentTime) {
        this.currentTime = currentTime;
    }

}
