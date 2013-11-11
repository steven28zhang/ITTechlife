/**
 * 
 */
package com.sxw.itl.common;

/**
 * @author stephenxianweizhang@gmail.com
 * 
 */
public class ITLConstants {

    public static String proxyHost = "172.28.48.13";
    public static int proxyPort = 3128;
    public static String securityEncryptionSeed = "sztechlife";
    public static int securityDefaultLength = 128;
    public static String securityDefaultTransformation = "AES";
    public static String MD5Transformation = "MD5";
    public static String AESTransformation = "AES";

    public interface NumberBin {
        int bin2power24 = 16777216;
        int bin2power16 = 65536;
        int bin2power8 = 256;
    }

    public interface ErrorCodes {
        String argumentException_5001 = "5001";
        String internalServerError_400 = "400";
        String INVALID_SOURCE_DATATYPE_4120 = "4120";
    }

    public interface ErrorMessage {
        String INTERNAL_SERVER_ERROR = "Record submission failed due to internal error";
    }

    public interface EncrptionMode {

        public static final String ENCRYPT_MODE = "encrypt";
        public static final String DECRYPT_MODE = "decrypt";
    }

    public interface EncrptionType {
        public static final String MDFIVE = "MD5";
    }

    public interface Pages {
        public static final String SSO_LOGIN_PAGE = "sso/login";

        public static final String PUBLIC_ABOUTME = "public/aboutMe";
    }

    public interface Symbols {
        public static final String SYMBOL_COMMA = ".";

    }

    public interface OutputType {

        public static final String OUTPUT_XML = "xml";
        public static final String OUTPUT_XML_UPPER = "XML";
        public static final String OUTPUT_JSON = "json";
        public static final String OUTPUT_JSON_UPPER = "JSON";

    }

    public interface Encoding {

        public static final String UTF8STR = "UTF-8";
    }

    public interface BaiduKeys {
        public static final String HOURSINGAK = "388976d363f4154e602f8e1c60858533";
        public static final int HOURSINGAK_MAX_DAILY = 100000;
        public static final String PLACE_SEARCH = "http://api.map.baidu.com/place/v2/search";
        /**
         * 鍙傛暟 鏄惁蹇呴』 榛樿鍊�鏍煎紡涓句緥 鍚箟<br>
         * q(query) 鏄�鏃�涓叧鏉戙�ATM銆佺櫨搴﹀ぇ鍘�妫�储鍏抽敭瀛�br> tag 鍚�鏃�鏃ュ紡鐑х儰/閾佹澘鐑с�鏈濆澶ц
         * 鏍囩椤癸紝涓巕缁勫悎杩涜妫�储<br>
         * output 鍚�xml json鎴杧ml 杈撳嚭鏍煎紡涓簀son鎴栬�xml<br>
         * scope 鏄�1 1銆� 妫�储缁撴灉璇︾粏绋嬪害銆傚彇鍊间负1
         * 鎴栫┖锛屽垯杩斿洖鍩烘湰淇℃伅锛涘彇鍊间负2锛岃繑鍥炴绱OI璇︾粏淇℃伅<br>
         * filter 鍚�鏃�filter=industry_type:cater|sort_name:price|sort_rule:0|
         * price_section:100,200|groupon:0|discount:0
         * 妫�储杩囨护鏉′欢锛屽綋scope鍙栧�涓�鏃讹紝鍙互璁剧疆filter杩涜鎺掑簭銆�br>
         * industry_type锛氳涓氱被鍨�br> 娉ㄦ剰锛氳缃瀛楁鍙彁楂樻绱㈤�搴﹀拰杩囨护绮惧害銆�br>
         * industry_type鍙栧�濡備笅锛�br> hotel:瀹鹃<br>
         * cater:椁愰ギ<br>
         * life:鐢熸椿濞变箰<br>
         * sort_name锛氭帓搴忓瓧娈�br> 鍙栧�鏍规嵁industry_type瀛楁鐨勫�鑰屽畾銆�br>
         * (1)industry_type涓篽otel鏃讹紝sort_name鍙栧�锛�br> default:榛樿锛�br> price:浠锋牸<br>
         * total_score:濂借瘎<br>
         * level锛氭槦绾�br> health_score锛氬崼鐢�br> distance:璺濈鎺掑簭锛屽彧鏈夊懆杈规绱㈡湁鏁�br>
         * (2)industry_type鍙栧�cater鏃讹紝sort_name鍙栧�锛�br> default锛氶粯璁�br>
         * taste_rating锛氬彛鍛�br> price锛氫环鏍�br> overall_rating锛氬ソ璇�br>
         * service_rating锛氭湇鍔�br> distance:璺濈鎺掑簭锛屽彧鏈夊懆杈规绱㈡湁鏁�br>
         * (3)industry_type鍙栧�life鏃讹紝sort_name鍙栧�锛�br> default锛氶粯璁�br>
         * price锛氫环鏍�br> overall_rating锛氬ソ璇�br> comment_num锛氭湇鍔�br>
         * distance锛氳窛绂绘帓搴忥紝鍙湁鍛ㄨ竟妫�储鏈�br>
         * sort_rule锛氭帓搴忚鍒欙紝鍙栧�濡備笅锛�锛氫粠楂樺埌浣庯紝1锛氫粠浣庡埌楂橈紱<br>
         * price_section锛氫环鏍煎尯闂达紱<br>
         * groupon锛氭槸鍚︽湁鍥㈣喘锛�涓烘湁鍥㈣喘锛�涓烘棤鍥㈣喘锛�br>
         * discount锛氭槸鍚︽墦鎶橈紝1涓烘湁鎵撴姌锛�涓烘棤鎵撴姌锛�br> page_size 鍚�10 10
         * 杩斿洖璁板綍鏁伴噺锛岄粯璁や负10鏉¤褰曪紝鏈�ぇ杩斿洖缁撴灉涓�0鏉°�<br>
         * page_num 鍚�0 0銆�銆� 鍒嗛〉椤电爜锛岄粯璁や负0,0浠ｈ〃绗竴椤碉紝1浠ｈ〃绗簩椤碉紝浠ユ绫绘帹銆�br> ak
         * 鏄�鏃�E4805d16520de693a3fe707cdc962045
         * 鐢ㄦ埛鐨勮闂瘑閽ワ紝蹇呭～椤广�v2涔嬪墠璇ュ睘鎬т负key銆�br> sn 鍚�鏃�鐢ㄦ埛鐨勬潈闄愮鍚嶃�<br>
         * timestamp 鍚�鏃�璁剧疆sn鍚庤鍊煎繀濉�<br>
         */
        public static final String PLACE_SEARCH_DEMO = "http://api.map.baidu.com/place/v2/search?&q=%E4%B8%9C%E6%96%B9%E6%98%8E%E7%8F%A0&region=%E4%B8%8A%E6%B5%B7&output=json&ak=388976d363f4154e602f8e1c60858533";
        public static final String PLACE_DETAIL = "http://api.map.baidu.com/place/v2/detail";
        public static final String PLACE_SUGGESTION = "http://api.map.baidu.com/place/v2/suggestion/";
        /**
         * 鍙傛暟鍚嶇О 鏄惁蹇呴』 榛樿鍊�鏍煎紡 澶囨敞<br>
         * q(query) 鏄�鏃�涓婂湴銆佸ぉ瀹夈�涓叧銆乻hanghai 杈撳叆寤鸿鍏抽敭瀛楋紙鏀寔鎷奸煶锛�br> region
         * 鏄�鏃�鍏ㄥ浗銆佸寳浜競銆�31銆佹睙鑻忕渷绛�鎵�睘鍩庡競/鍖哄煙鍚嶇О鎴栦唬鍙�br> output 鍚�xml json銆亁ml
         * 杩斿洖鏁版嵁鏍煎紡锛屽彲閫塲son銆亁ml涓ょ<br>
         * ak 鏄�鏃�E4805d16520de693a3fe707cdc962045 寮�彂鑰呰闂瘑閽ワ紝蹇呴�銆�br> sn
         * 鍚�鏃�E4805d16520de693a3fe707cdc962045 鐢ㄦ埛鐨勬潈闄愮鍚�br> timestamp
         * 鍚�鏃�E4805d16520de693a3fe707cdc962045 璁剧疆sn鍚庤鍊煎繀閫�br>
         */
        public static final String PLACE_SUGGESTION_DEMO = "http://api.map.baidu.com/place/v2/suggestion?query=%E5%A4%A9%E5%AE%89%E9%97%A8&region=131%20&output=json&ak=388976d363f4154e602f8e1c60858533";
        // public static final String PLACE_SEARCH="";
    }
}
