/**
 * 
 */
package com.sxw.itl.openid.handler.files;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sxw.itl.openid.handler.BasedHanlders;
import com.sxw.itl.utils.track.TrackHttpRequest;

/**
 * @author stephenxianweizhang@gmail.com
 * 
 */
@Controller
public class UploadFile extends BasedHanlders {

	private final Log logger = LogFactory.getLog(getClass());
	private final String className = getClass().getName();

	@RequestMapping(value = "uploadFile", method = RequestMethod.GET)
	public String uploadFile(Model uiModel,
			HttpServletResponse httpServletResponse) {
		final String methodName = className + ":uploadFile:";

		logger.debug(methodName);
		return "files/uploadFile";
	}

	@RequestMapping(value = "uploadFile", method = RequestMethod.POST)
	public String handleUploadFile(HttpServletResponse httpServletResponse,
			HttpServletRequest httpServletRequest) {

		final String methodName = className + ":handleUploadFile:";
		TrackHttpRequest.outputHttpRequest(httpServletRequest);

		// WAY one

		// try {
		// DataInputStream in = new DataInputStream(
		// httpServletRequest.getInputStream());
		// int formDataLength = httpServletRequest.getContentLength();
		// logger.debug(methodName + "formDataLength:" + formDataLength);
		// byte[] readFile = FileOperations.readUploadFile(in, formDataLength);
		// String readFileStr = new String(readFile, "UTF-8");
		// logger.debug(methodName + "readFileStr:\n" + readFileStr);
		// httpServletRequest.setAttribute("readFileStr", readFileStr);
		// } catch (IOException e) {
		//
		// }

		// WAY two
		try {
			List<FileItem> items = new ServletFileUpload(
					new DiskFileItemFactory()).parseRequest(httpServletRequest);
			for (FileItem item : items) {
				if (!item.isFormField()) {
					// Process form file field (input type="file").
					String fieldname = item.getFieldName();
					String filename = FilenameUtils.getName(item.getName());
					InputStream filecontent = item.getInputStream();
					StringWriter writer = new StringWriter();
					IOUtils.copy(filecontent, writer, "UTF-8");
					String readFileStr = writer.toString();
					logger.debug(methodName + "fieldname:" + fieldname
							+ ":filename:" + filename + ":readFileStr:\n"
							+ readFileStr);
					httpServletRequest.setAttribute("readFileStr", readFileStr);
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "files/showFiles";
	}
}
