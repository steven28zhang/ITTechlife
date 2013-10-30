/**
 * 
 */
package com.sxw.hlseven.controller;

import ca.uhn.hl7v2.model.DataTypeException;

import com.sxw.hlseven.hellowold.CommonTS;

/**
 * @author Stephen.Zhang@covisint.com
 * 
 */
public final class HelloHLSeven {

    /**
     * @param args
     */
    public static void main(String[] args) {
        CommonTS ts = new CommonTS();
        try {
            ts.setValue("201310251001-0700");
            System.out.println(ts.getValue());
        } catch (DataTypeException e) {
        }
    }

}
