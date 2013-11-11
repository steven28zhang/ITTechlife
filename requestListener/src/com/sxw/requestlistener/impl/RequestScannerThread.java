/**
 * 
 */
package com.sxw.requestlistener.impl;

import com.sxw.requestlistener.constants.RLConstants.RLRequestTimesMax;
import com.sxw.requestlistener.entity.RLRequest;

/**
 * @author Stephen.Zhang@covisint.com
 * 
 */
public class RequestScannerThread implements Runnable {

    private boolean runFlag = true;

    @Override
    public void run() {
        do {
            System.out.println("RequestScannerThread:BEGIN:");
            try {
                if (RequestHandler.reqTmpList != null) {
                    // count the request
                    for (int i = 0; i < RequestHandler.reqTmpList.size(); i++) {
                        RLRequest requestTmp = RequestHandler.reqTmpList.get(i);
                        if (RequestHandler.reqCounterPD.containsKey(requestTmp.getRemoteIP())) {
                            int counterTmp = RequestHandler.reqCounterPD.get(requestTmp.getRemoteIP());
                            if (counterTmp++ >= RLRequestTimesMax.monitorTimesPerday) {

                            }
                            RequestHandler.reqCounterPD.put(requestTmp.getRemoteIP(), counterTmp);
                        } else {
                            RequestHandler.reqCounterPD.put(requestTmp.getRemoteIP(), 1);
                        }
                    }
                    RequestHandler.outputCurrentStatus();
                    Thread.sleep(100);
                    // analyze the request
                    // TODO delete
                    runFlag = false;
                }
            } catch (Exception e) {
            }
            System.out.println(":RequestScannerThread:END");
        } while (runFlag);
    }

    /**
     * @return the runFlag
     */
    public boolean isRunFlag() {
        return runFlag;
    }

    /**
     * @param runFlag
     *            the runFlag to set
     */
    public void setRunFlag(boolean runFlag) {
        this.runFlag = runFlag;
    }

}
