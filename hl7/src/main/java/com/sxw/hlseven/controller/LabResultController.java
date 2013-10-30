/**
 * 
 */
package com.sxw.hlseven.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sxw.hlseven.common.AbstractSpringBasedController;
import com.sxw.hlseven.conversion.ConvertJsonToJavaObj;
import com.sxw.hlseven.entities.LabResult;
import com.sxw.hlseven.validation.Validators;
import com.sxw.itl.utils.string.StringUtils;

/**
 * @author Stephen.Zhang@covisint.com
 * 
 */
@Controller
@RequestMapping("/hlseven")
public class LabResultController extends AbstractSpringBasedController {

    private final static String CLASSNAME = LabResultController.class.getName();
    private static Logger logger = LogManager.getLogger(CLASSNAME);

    @Autowired
    private ResourceBundleMessageSource messageSource;

    @Autowired
    private Validators validators;

    @Autowired
    private ConvertJsonToJavaObj convertJsonToJavaObj;

    /**
     * 
     * @param sourceTpId
     * @param jsonObj
     * @param request
     * @param response
     * @param error
     */
    @RequestMapping(value = "/handler/{sourceTpId}/storeLabResut", method = { RequestMethod.POST })
    public void insertLabResut(@PathVariable String sourceTpId, @RequestBody String jsonObj,
            HttpServletRequest request, HttpServletResponse response, BindingResult error) {
        String methodName = CLASSNAME + ":insertLabResut:";
        logger.debug(methodName + ":sourceTpId:" + sourceTpId);
        LabResult labResult = null;
        if (StringUtils.isNotEmptyAndNull(jsonObj)) {
            try {
                labResult = convertJsonToJavaObj.convertJsonToJava(jsonObj, LabResult.class);
                if (labResult == null) {

                }
                labResult.setSourceTpId(sourceTpId);
                labResult.setPatientId("88888");
                validators.validateJson(error, labResult);
                if (error.hasErrors()) {
                    List<ObjectError> objectErrors = error.getAllErrors();

                    if (objectErrors != null && objectErrors.size() > 0) {
                        ObjectError objectError = objectErrors.get(0);
                        if (objectError != null) {
                            String apiStatusCode = objectError.getCode()+".errorCode";
                            String errorMsg = messageSource.getMessage(apiStatusCode, null, Locale.US);
                            System.out.println(errorMsg);

                        }
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {

        }
    }
}
