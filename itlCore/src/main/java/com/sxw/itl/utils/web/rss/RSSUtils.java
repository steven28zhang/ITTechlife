/**
 * 
 */
package com.sxw.itl.utils.web.rss;

import java.io.ByteArrayInputStream;
import java.io.Reader;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.util.HttpUtil;
import com.sun.syndication.feed.synd.SyndContent;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

/**
 * @author Stepheh Xianwei Zhang
 * 
 */
public final class RSSUtils {

	public static String CLASSNAME = RSSUtils.class.getName();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 String url =
		 "http://www.carlsonwagonlit.com/en/global/news_and_media/hot_news/rssfeed.xml";
//		String url = "http://www.carlsonwagonlit.com/en/global/news_and_media/hot_news/rssfeed.rss";
		fetchRSSFeed(url);

	}

	public static SyndFeed fetchRSSFeed(String url) {

		final String METHODNAME = CLASSNAME + " fetchRSSFeed: ";
		final String MSG = METHODNAME + " rss feed url: " + url;

		SyndFeed feed = null;
		SyndFeedInput input = null;
		// TODO DELETE THE PROXY WHIHC USED TO DO LOCAL TESTING

		// Soltuion 1: by http
		ByteArrayInputStream bais = null;
		byte[] xml = null;
		try {
			input = new SyndFeedInput();
			xml = HttpUtil.URLtoByteArray(url);
			bais = new ByteArrayInputStream(xml);
			feed = input.build(new XmlReader(bais));

		} catch (java.net.ConnectException ce) {
			// log.debug(METHODNAME, ce);
		} catch (Exception e) {
			// log.debug(METHODNAME, e);

		} finally {
			if (bais != null) {
				try {
					bais.close();
				} catch (Exception e) {
					// log.info(MSG, e);
				}
			}
		}

		// Solution 2: by URL
		if (feed == null || feed.getEntries().size() < 1) {
			try {

				URL url_ = new URL(url);
				url_.openConnection();
				input = new SyndFeedInput();
				// Reader reader = new XmlReader(url_);
				Reader reader = new XmlReader(url_.openConnection()
						.getInputStream());
				feed = input.build(reader);

			} catch (java.net.ConnectException ce) {
				// log.error(MSG, ce);
				// TODO to delete or change the proxy
				Proxy proxy = new Proxy(Type.HTTP, new InetSocketAddress(
						"10.66.1.108", 3128));
				try {
					URL url_ = new URL(url);
					// TODO DELETE LOCAL TESTING
					url_.openConnection(proxy);
					input = new SyndFeedInput();
					// Reader reader = new XmlReader(url_);
					Reader reader = new XmlReader(url_.openConnection(proxy)
							.getInputStream());
					feed = input.build(reader);
				} catch (Exception e) {
					// log.debug(METHODNAME, e);
				}

			} catch (Exception e) {
				System.out.println("|"+e.getMessage());

			}
		}

		if (feed != null) {
			List entries = feed.getEntries();

			for (int j = 0; j < entries.size(); j++) {
				SyndEntry entry = (SyndEntry) entries.get(j);

				String entryLink = entry.getLink();

				String author = entry.getAuthor();

				SyndContent content = entry.getDescription();
				String contentValue = content.getValue();
				contentValue = contentValue.replaceAll("\n", "");
				contentValue = contentValue.replaceAll("\t", "");
				System.out.println(contentValue.length());
				List t = entry.getContents();
				String title = entry.getTitle();

				List contents = new ArrayList();

				if (content == null) {
					contents = entry.getContents();
				} else {
					contents.add(content);
				}
			}
		}
		return feed;
	}
}
