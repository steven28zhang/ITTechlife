/**
 * 
 */
package com.sxw.itl.algorithm;

/**
 * {@link http://blogread.cn/it/article/3302?f=wb}
 * 
 */
public final class M2NConvert {

    /**
     * @param args
     */
    public static void main(String[] args) {
        doTest();

    }

    static void doTest() {
        System.out.println("" + String.valueOf((char) ('0' + 1)));
        System.out.println("" + String.valueOf((char) ('a' + 35 - 10)));
        String nValue="";
        String MValue="123";
        String Shang = MValue;
        while(Shang.length() > 0) {
                nValue = qiuyu(MValue, 10, 8) + nValue;
        }
        System.out.println("nValue:" + nValue);
    }

    static String M2N(final String MValue, final int M, final int N) {

        return "";
    }

    public static String qiuyu(String MTempValue, final int M, final int N) {
        String Shang = "";
        int temp = 0;
        while (MTempValue.length() > 0) {
            int t = getIntFromStr(MTempValue.substring(0, 1));
            MTempValue = MTempValue.substring(1);
            temp = temp * M + t;
            Shang += getStrFromInt(temp / N);
            temp = temp % N;
        }
        while (Shang.length() > 0 && Shang.charAt(0) == '0') {
            Shang = Shang.substring(1);
        }
        return getStrFromInt(temp);
    }

    public static int getIntFromStr(String str) {
        return str.charAt(0) <= '9' && str.charAt(0) >= '0' ? str.charAt(0) - '0' : str.charAt(0) - 'a' + 10;
    }

    public static String getStrFromInt(int value) {
        String result = null;
        if (value >= 0 && value <= 9)
            result = String.valueOf((char) ('0' + value));
        else if (value > 9 && value < 36) {
            result = String.valueOf((char) ('a' + value - 10));
        } else {
            result = "-1";
        }
        return result;
    }
}
