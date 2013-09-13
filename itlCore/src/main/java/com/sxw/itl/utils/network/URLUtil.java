/**
 * 
 */
package com.sxw.itl.utils.network;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;

import com.sxw.itl.common.ITLConstants;
import com.sxw.itl.common.ITLConstants.BaiduKeys;
import com.sxw.itl.convert.apache.ApacheIOUtils;

/**
 * @author stephenxianweizhang@gmail.com
 * 
 */
public final class URLUtil {

	public static Proxy proxy = new Proxy(Type.HTTP, new InetSocketAddress(
			ITLConstants.proxyHost, ITLConstants.proxyPort));

	/**
	 * <b>official
	 * website:http://developer.baidu.com/map/webservice-placeapi.htm</b><br>
	 * <br>
	 * 
	 * <b>1.什么是Place API？</b><br>
	 * Place API 是一类简单的HTTP接口，用于返回查询某个区域的某类POI数据，且提供单个POI的详情查询服务，用户可以使用C#、C++、
	 * Java等开发语言发送HTTP请求且接收json、xml的数据。<br>
	 * 
	 * <b>2.功能介绍</b><br>
	 * Place API 提供区域检索POI服务、POI详情服务与团购信息检索服务、商家团购详情查询。<br>
	 * <br>
	 * 1. 区域检索POI服务提供三种区域检索方法：<br>
	 * <br>
	 * 城市内检索（对应JavaScriptAPI的Search方法）<br>
	 * 矩形检索（对应JavaScript API的SearchInBound方法）<br>
	 * 圆形区域检索（对应JavaScript的SearchNearBy方法）。<br>
	 * 2. POI详情服务提供查询单个POI的详情信息，如好评。<br>
	 * <br>
	 * 3. 团购信息检索服务提供三种区域检索方法：<br>
	 * <br>
	 * 城市内检索<br>
	 * 矩形检索<br>
	 * 圆形区域检索<br>
	 * 4. 商家团购详情查询。<br>
	 * <br>
	 * 用户可以使用C# 、C++、Java等开发语言发送HTTP请求且接收JSON、XML的返回数据。<br>
	 * <br>
	 * 3.使用说明<br>
	 * Place API 是一套免费使用的API接口，调用次数限制为10万次/天。<br>
	 * 
	 * @param queryWords
	 * @param region
	 * @param outputType
	 * @return
	 */
	public static String baiduPlaceSearch(final String queryWords,
			final String region, final String outputType) {
		String result = "";
		final String url = BaiduKeys.PLACE_SEARCH_DEMO;
		try {
			URL url_ = new URL(url);
			url_.openConnection();
			result = ApacheIOUtils.convertInputStreamToString(url_
					.openConnection().getInputStream());
		} catch (java.net.ConnectException e) {
			e.printStackTrace();
			try {
				URL url_ = new URL(url);
				url_.openConnection(proxy);
				result = ApacheIOUtils.convertInputStreamToString(url_
						.openConnection(proxy).getInputStream());
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} catch (IOException e) {

		}
		return result;
	}

	/**
	 * <h2>official
	 * website:http://developer.baidu.com/map/place-suggestion-api.htm</h2><br>
	 * <br>
	 * 产品介绍<br>
	 * Place suggestion API
	 * 是一套以HTTP形式提供的匹配用户输入关键字辅助信息、提示接口，可返回json或xml格式的一组建议词条的数据。<br>
	 * <br>
	 * 该套API免费对外开放，您需先申请密钥（ak） ，1个ak支持10万次/天。<br>
	 * <br>
	 * 适用场景<br>
	 * 配合Place API使用：使用本接口请求，可调出匹配用户输入的关键字的建议列表，用户选择列表中确定的一条，结合Place
	 * API返回查询的结果。效果如：<br>
	 * <br>
	 * 
	 * 
	 * 使用限制<br>
	 * 1个ak支持10万次/天，超过请求不返回结果。<br>
	 * 
	 * @param queryWords
	 * @param region
	 * @param outputType
	 * @return
	 */
	public static String baiduPlaceSuggestionSearch(final String queryWords,
			final String region, final String outputType) {
		String result = "";
		final String url = BaiduKeys.PLACE_SUGGESTION_DEMO;
		try {
			URL url_ = new URL(url);
			url_.openConnection();
			result = ApacheIOUtils.convertInputStreamToString(url_
					.openConnection().getInputStream());
		} catch (java.net.ConnectException e) {
			e.printStackTrace();
			try {
				URL url_ = new URL(url);
				url_.openConnection(proxy);
				result = ApacheIOUtils.convertInputStreamToString(url_
						.openConnection(proxy).getInputStream());
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} catch (IOException e) {

		}
		return result;
	}
}
