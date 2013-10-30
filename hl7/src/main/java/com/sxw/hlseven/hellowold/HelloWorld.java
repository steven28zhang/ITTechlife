/**
 * 
 */
package com.sxw.hlseven.hellowold;

import java.net.URL;

/**
 * @author Stephen.Zhang@covisint.com
 * 
 */
public final class HelloWorld {

    /**
     * @param args
     */
    public static void main(String[] args) {

        HelloWorld helloWorld = new HelloWorld();
        System.out.println(HelloWorld.class.getSimpleName() + "|" + helloWorld.toString());
        helloWorld.test1();

    }

    private void test1() {

        URL url = this.getClass().getResource("/schema/json/" + "labResult.json");
        System.out.println(url.getPath());
    }

}
