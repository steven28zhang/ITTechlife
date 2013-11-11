/**
 * 
 */
package com.sxw.itl.log.entity;

import java.util.Date;

import com.sxw.itl.log.constants.ITLLogConstants.ITLLogType;

/**
 * traceID and content are required<br>
 * 
 * @author stephenxianweizhang@gmail.com
 * 
 */
public class LogEntity {

    private long traceID;
    private String rpcID;
    private String content;
    private String label;
    private String appName;
    private String ipAdd;
    private ITLLogType logType;
    private Date activityTime;

    /**
     * @return the traceID
     */
    public long getTraceID() {
        return traceID;
    }

    /**
     * @param traceID
     *            the traceID to set
     */
    public void setTraceID(long traceID) {
        this.traceID = traceID;
    }

    /**
     * @return the appName
     */
    public String getAppName() {
        return appName;
    }

    /**
     * @param appName
     *            the appName to set
     */
    public void setAppName(String appName) {
        this.appName = appName;
    }

    /**
     * @return the ipAdd
     */
    public String getIpAdd() {
        return ipAdd;
    }

    /**
     * @param ipAdd
     *            the ipAdd to set
     */
    public void setIpAdd(String ipAdd) {
        this.ipAdd = ipAdd;
    }

    /**
     * @return the logType
     */
    public ITLLogType getLogType() {
        return logType;
    }

    /**
     * @param logType
     *            the logType to set
     */
    public void setLogType(ITLLogType logType) {
        this.logType = logType;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     *            the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the activityTime
     */
    public Date getActivityTime() {
        return activityTime;
    }

    /**
     * @param activityTime
     *            the activityTime to set
     */
    public void setActivityTime(Date activityTime) {
        this.activityTime = activityTime;
    }

    /**
     * @return the rpcID
     */
    public String getRpcID() {
        return rpcID;
    }

    /**
     * @param rpcID
     *            the rpcID to set
     */
    public void setRpcID(String rpcID) {
        this.rpcID = rpcID;
    }

    /**
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label
     *            the label to set
     */
    public void setLabel(String label) {
        this.label = label;
    }
}
