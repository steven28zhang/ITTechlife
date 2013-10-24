/**
 * 
 */
package com.sxw.hlseven.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sxw.hlseven.common.AbstractSpringBasedController;

/**
 * @author Stephen.Zhang@covisint.com
 * 
 */
@Controller
@RequestMapping("/hlseven")
public class LabResultController extends AbstractSpringBasedController {

    private final static String CLASSNAME = LabResultController.class.getName();
    private static Logger logger = LogManager.getLogger(CLASSNAME);

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
        
    }
}
