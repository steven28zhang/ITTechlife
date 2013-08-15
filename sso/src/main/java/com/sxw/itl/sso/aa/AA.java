/**
 * 
 */
package com.sxw.itl.sso.aa;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.StandardEnvironment;

/**
 * @author stephenxianweizhang@gmail.com
 * 
 */
public final class AA {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String usrDir = System.getProperty("user.dir");

		String fsep = System.getProperty("file.separator");

		String xmlFile = usrDir + fsep + "src" + fsep + "resources" + fsep
				+ "application-hw.xml";
		System.out.println("xmlFile:" + xmlFile);
		StandardEnvironment se= new StandardEnvironment();
		Map<String, Object> seMap=se.getSystemEnvironment();
		for(String key:seMap.keySet()){
			System.out.println(key+":|:" + seMap.get(key));
		}
		
		ApplicationContext context = new ClassPathXmlApplicationContext("/resources/application-hw.xml");
		Authentication authentication = (Authentication) context
				.getBean("authenticate");
		System.out.println(""
				+ authentication.authenticate(null, null, null, null));
	}

}
