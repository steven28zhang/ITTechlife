/**
 * 
 */
package com.sxw.requestlistener.constants;

/**
 * @author Stephen.Zhang@covisint.com
 * 
 */
public final class RLConstants {

    /**
     * define the value of levels:normal;temp;warning;forbiddance;<br>
     * 
     * @author Stephen.Zhang@covisint.com
     * 
     */
    public interface RLFeedbackLevel {

        int NORMAL = -1000;
        int TEMP = 0;
        int WARNING_L1 = 200;
        int WARNING_L2 = 500;
        int FORBID = 1000;
    }

    public interface RLRequestTimesMax {
        int monitorTimesPerday = 60;
        int fiveSecondsLow = 5;
        int fiveSecondsMiddle = 10;
        int fiveSecondsHigh = 25;
        int tenSecondsLow = 10;
        int tenSecondsMiddle = 20;
        int tenSecondsHigh = 50;
        int oneMinuteLow = 60;
    }

    public interface applicationScale {
        int tiny = 5;
        int small = 50;
        int nearMedium = 100;
        int medium = 200;
        int large = 500;
        int grand = 1000;
        int huge = 10000;
        int superHuge = 50000;
    }

    public interface timeConstants {
        int millios = 1000;
        int second = 1;
        int secondM = second * millios;
        int minute = 60;
        int minuteM = minute * millios;
        int hour = minute * 60;
        int hourM = hour * millios;
        int day = hour * 24;
        int dayM = day * millios;
    }

    public interface UserAgentTesting {
        String chrome = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/30.0.1599.101 Safari/537.36";
        String firefox = "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0";
        String msie = "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1; WOW64; Trident/4.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; .NET4.0C; .NET4.0E; AskTbW3I/5.15.4.23821; InfoPath.3)";
        String safari = "Mozilla/5.0 (iPad; CPU OS 6_0 like Mac OS X) AppleWebKit/536.26 (KHTML, like Gecko) Version/6.0 Mobile/10A5355d Safari/8536.25";
        String opera = "Opera/9.80 (Windows NT 6.0) Presto/2.12.388 Version/12.14";
    }
}
