package com.sxw.itl.utils.security.encryption;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 
 * @author stephenxianweizhang@gmail.com
 * 
 */
public class MDFiveEncryptionTest {

	@Test
	public void testEncodeByMD5() {
		String testTmp = MDFiveEncryption.encodeByMD5("china");
		assertEquals("8a7d7ba288ca0f0ea1ecf975b026e8e1", testTmp);
	}

}
