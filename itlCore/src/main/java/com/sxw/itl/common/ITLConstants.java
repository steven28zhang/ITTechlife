/**
 * 
 */
package com.sxw.itl.common;

/**
 * @author stephenxianweizhang@gmail.com
 * 
 */
public class ITLConstants {

	public static String proxyHost = "";
	public static int proxyPort = 0;

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
		public static final String HOURSINGAK = "31882976d363f4154e602f8e1c60858533";
		public static final int HOURSINGAK_MAX_DAILY = 100000;
		public static final String PLACE_SEARCH = "http://api.map.baidu.com/place/v2/search";
		/**
		 * 参数 是否必须 默认值 格式举例 含义<br>
		 * q(query) 是 无 中关村、ATM、百度大厦 检索关键字<br>
		 * tag 否 无 日式烧烤/铁板烧、朝外大街 标签项，与q组合进行检索<br>
		 * output 否 xml json或xml 输出格式为json或者xml<br>
		 * scope 是 1 1、2 检索结果详细程度。取值为1 或空，则返回基本信息；取值为2，返回检索POI详细信息<br>
		 * filter 否 无 filter=industry_type:cater|sort_name:price|sort_rule:0|
		 * price_section:100,200|groupon:0|discount:0
		 * 检索过滤条件，当scope取值为2时，可以设置filter进行排序。<br>
		 * industry_type：行业类型<br>
		 * 注意：设置该字段可提高检索速度和过滤精度。<br>
		 * industry_type取值如下：<br>
		 * hotel:宾馆<br>
		 * cater:餐饮<br>
		 * life:生活娱乐<br>
		 * sort_name：排序字段<br>
		 * 取值根据industry_type字段的值而定。<br>
		 * (1)industry_type为hotel时，sort_name取值：<br>
		 * default:默认；<br>
		 * price:价格<br>
		 * total_score:好评<br>
		 * level：星级<br>
		 * health_score：卫生<br>
		 * distance:距离排序，只有周边检索有效<br>
		 * (2)industry_type取值cater时，sort_name取值：<br>
		 * default：默认<br>
		 * taste_rating：口味<br>
		 * price：价格<br>
		 * overall_rating：好评<br>
		 * service_rating：服务<br>
		 * distance:距离排序，只有周边检索有效<br>
		 * (3)industry_type取值life时，sort_name取值：<br>
		 * default：默认<br>
		 * price：价格<br>
		 * overall_rating：好评<br>
		 * comment_num：服务<br>
		 * distance：距离排序，只有周边检索有<br>
		 * sort_rule：排序规则，取值如下：0：从高到低，1：从低到高；<br>
		 * price_section：价格区间；<br>
		 * groupon：是否有团购，1为有团购，0为无团购；<br>
		 * discount：是否打折，1为有打折，0为无打折；<br>
		 * page_size 否 10 10 返回记录数量，默认为10条记录，最大返回结果为20条。<br>
		 * page_num 否 0 0、1、2 分页页码，默认为0,0代表第一页，1代表第二页，以此类推。<br>
		 * ak 是 无 E4805d16520de693a3fe707cdc962045 用户的访问密钥，必填项。v2之前该属性为key。<br>
		 * sn 否 无 用户的权限签名。<br>
		 * timestamp 否 无 设置sn后该值必填。<br>
		 */
		public static final String PLACE_SEARCH_DEMO = "http://api.map.baidu.com/place/v2/search?&q=饭店&region=北京&output=json&ak=E4805d16520de693a3fe707cdc962045";
		public static final String PLACE_DETAIL = "http://api.map.baidu.com/place/v2/detail";
		public static final String PLACE_SUGGESTION = "http://api.map.baidu.com/place/v2/suggestion/";
		/**
		 * 参数名称 是否必须 默认值 格式 备注<br>
		 * q(query) 是 无 上地、天安、中关、shanghai 输入建议关键字（支持拼音）<br>
		 * region 是 无 全国、北京市、131、江苏省等 所属城市/区域名称或代号<br>
		 * output 否 xml json、xml 返回数据格式，可选json、xml两种<br>
		 * ak 是 无 E4805d16520de693a3fe707cdc962045 开发者访问密钥，必选。<br>
		 * sn 否 无 E4805d16520de693a3fe707cdc962045 用户的权限签名<br>
		 * timestamp 否 无 E4805d16520de693a3fe707cdc962045 设置sn后该值必选<br>
		 */
		public static final String PLACE_SUGGESTION_DEMO = "http://api.map.baidu.com/place/v2/suggestion?query=%E5%A4%A9%E5%AE%89%E9%97%A8&region=131%20&output=json&ak=E4805d16520de693a3fe707cdc962045";
		// public static final String PLACE_SEARCH="";
	}
}
