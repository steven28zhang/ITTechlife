/**
 * 
 */
package com.sxw.itl.common;

import com.sxw.itl.utils.network.URLUtil;

/**
 * @author stephenxianweizhang@gmail.com
 * 
 */
public final class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String r = URLUtil.baiduPlaceSuggestionSearch(null, null, null);
		System.out.println("result:\n" + r);
		 r = URLUtil.baiduPlaceSearch(null, null, null);
			System.out.println("result:\n" + r);
	}
}
