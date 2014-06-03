/**
 * 
 */
package com.sxw.itl.language.java;

import java.lang.reflect.Field;

/**
 * @author Stephen.Zhang@Covisint.com
 * 
 */
public final class Hjava {

    public final static String CLASS_NAME = Hjava.class.getName();
    public final String t = "t";

    /**
     * @param args
     */
    public static void main(String[] args) {
        testInflection();
    }

    static void testInflection() {
        try {
            Class<?> hj = Class.forName("com.sxw.itl.language.java.Hjava");
            Field[] f = hj.getDeclaredFields();

            if (f != null && f.length > 0) {
                for (int i = 0; i < f.length; i++) {
                    System.out.println(CLASS_NAME + ":i:" + i + ":" + f[i]);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
