/**
 * 
 */
package com.sxw.itl.interview.impl;

import com.sxw.itl.interview.Interview.ConvertIPFromStringToLong;
import com.sxw.itl.interview.Interview.M2N;
import com.sxw.itl.utils.convert.ConvertUtil;

/**
 * @author stephenxianweizhang@gmail.com
 * 
 */
public final class InterviewImpl implements ConvertIPFromStringToLong, M2N {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    @Override
    public String convertM2N(String mValue, int m, int n) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Integer convertIPFromStringToLong(String ipAdd) {
        if(ipAdd.length()<15){
            return ConvertUtil.convertIP4FromStringToInt(ipAdd);
        }
        return null;
    }

}
