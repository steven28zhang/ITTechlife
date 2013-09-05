package com.sxw.itl.exe;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.sxw.itl.BasedTest;

/**
 * 
 * @author stephenxianweizhang@gmail.com
 * 
 */
public class FileOperationsTest extends BasedTest {

	private static final String SPLIT_SIGN = "|";
	FileOperations fo = null;
	String fileName = null;

	@Before
	public void setUp() throws Exception {
		fo = new FileOperations();
		StringBuffer filePath = new StringBuffer(usrDir);
		String outputPath = "bin";
		filePath.append(fsep).append(outputPath).append(fsep);
		fileName = filePath + "convert.txt";
	}

	@Test
	public void testReverseOrderOfFileContent() {
		try {
			fo.reverseOrderOfFileContent(fileName, SPLIT_SIGN);
		} catch (Exception e) {
		}
	}

	@Test(expected = NullPointerException.class)
	public void testReverseOrderOfFileContentNull() throws IOException {
		fo.reverseOrderOfFileContent(null, SPLIT_SIGN);
	}

	@Test(expected = FileNotFoundException.class)
	public void testReverseOrderOfFileContentFileNotExist() throws IOException {
		fo.reverseOrderOfFileContent(fileName+"change", SPLIT_SIGN);
	}

	@Test
	public void testReverseOrderString() {
		// more than one split signs
		String content = "o" + SPLIT_SIGN + "w" + SPLIT_SIGN + "t";
		assertEquals("two", fo.reverseOrderString(content, SPLIT_SIGN));
		// only one split sign
		content = "k" + SPLIT_SIGN + "o";
		assertEquals("ok", fo.reverseOrderString(content, SPLIT_SIGN));
	}

	@Test
	public void testReverseOrderStringNull() {
		assertEquals(null, fo.reverseOrderString("", SPLIT_SIGN));
		assertEquals(null, fo.reverseOrderString(null, SPLIT_SIGN));

	}

}
