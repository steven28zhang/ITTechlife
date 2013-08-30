/**
 * 
 */
package com.sxw.itl;

import java.util.Map;

import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.StandardEnvironment;

/**
 * Do Testing
 * 
 * @author stephenxianweizhang@gmail.com
 * 
 */
public class HelloWorld {

	public static void main(String[] args) {
		String usrDir = System.getProperty("user.dir");

		String fsep = System.getProperty("file.separator");

		String xmlFile = usrDir + fsep + "src" + fsep + "resources" + fsep
				+ "application-hw.xml";
		System.out.println("xmlFile:" + xmlFile);
		StandardEnvironment se = new StandardEnvironment();
		Map<String, Object> seMap = se.getSystemEnvironment();
		for (String key : seMap.keySet()) {
			System.out.println(key + ":|:" + seMap.get(key));
		}

		MessageSource resources = new ClassPathXmlApplicationContext(
				"application-context-itlwebcore.xml");
		String userNameMsg = resources.getMessage("itlo.index.username", null,
				"null", null);
		System.out.println("userNameMsg:" + userNameMsg);
	}
}
