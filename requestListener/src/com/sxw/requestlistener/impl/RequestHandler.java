/**
 * 
 */
package com.sxw.requestlistener.impl;

import java.util.Hashtable;
import java.util.concurrent.CopyOnWriteArrayList;

import com.sxw.requestlistener.entity.RLRequest;

/**
 * @author Stephen.Zhang@covisint.com
 * 
 */
public final class RequestHandler {

    public static CopyOnWriteArrayList<RLRequest> reqTmpList = new CopyOnWriteArrayList<RLRequest>();

    public static Hashtable<Integer, Integer> reqFeedBack = new Hashtable<Integer, Integer>();

    public static Hashtable<Long, RLRequest> requestHistory = new Hashtable<Long, RLRequest>();

    public static Hashtable<Integer, Integer> reqCounterPD = new Hashtable<Integer, Integer>();

    public static Hashtable<Integer, Integer> reqCounterPM = new Hashtable<Integer, Integer>();

    public static Hashtable<Integer, Integer> reqCounterPH = new Hashtable<Integer, Integer>();

    public static void outputCurrentStatus() {
        final String methodName = "RequestHandler:outputCurrentStatus:";
        // reqTmpList
        if (reqTmpList.size() > 0) {
            System.out.println();
            System.out.println(methodName + ":reqTmpList:BEGIN:");
            for (int i = 0; i < reqTmpList.size(); i++) {
                RLRequest requestTmp = reqTmpList.get(i);
                System.out.println(methodName + "requestTmp: remoteIP: " + requestTmp.getRemoteIP()
                        + "||||:UserAgent: " + requestTmp.getUserAgent() + " ||||:CurrentTime: "
                        + requestTmp.getCurrentTime() + " ||||:URI: " + requestTmp.getRequestURI());
            }
            System.out.println(methodName + ":reqTmpList:END:");
            System.out.println();
        }
    }

}
