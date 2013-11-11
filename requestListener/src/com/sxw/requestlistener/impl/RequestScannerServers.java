/**
 * 
 */
package com.sxw.requestlistener.impl;

/**
 * @author Stephen.Zhang@covisint.com
 * 
 */
public final class RequestScannerServers {

    private static RequestScannerThread requestScannerThread;

    public static void startServer() {
        requestScannerThread = new RequestScannerThread();
        requestScannerThread.run();
    }

    public static void stopServer() {
        if (requestScannerThread != null) {
            requestScannerThread.setRunFlag(false);
        }
    }
}
