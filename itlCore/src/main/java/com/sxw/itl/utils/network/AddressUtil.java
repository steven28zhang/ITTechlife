/**
 * 
 */
package com.sxw.itl.utils.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author u123199
 * 
 */
public final class AddressUtil {

    /**
     * 
     * @param dns
     * @return
     */
    public static String convertDNStoIP(final String dns) {
        if (dns != null) {
            try {
                InetAddress inetAddress = InetAddress.getByName(dns);
                if (inetAddress != null) {
                    return inetAddress.getHostAddress();
                }
            } catch (UnknownHostException e) {

            }
        }
        return null;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        String str = convertDNStoIP("www.google.com");
        System.out.println("str:" + str);

    }

}
